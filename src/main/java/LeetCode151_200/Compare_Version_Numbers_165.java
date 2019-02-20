package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 15:11
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 *
 *
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 *
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 *
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 *
 * Example 4:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 *
 * Example 5:
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 **/
public class Compare_Version_Numbers_165 {
    public static int compareVersion(String version1, String version2) {

        if(version1.equals(version2)){
            return 0;
        }
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int n = 0;
        int m = 0;
        while (n < split1.length && m < split2.length){
            if (Integer.valueOf(split1[n]) == Integer.valueOf(split2[m])){
                n++;
                m++;
            }else if (Integer.valueOf(split1[n]) > Integer.valueOf(split2[m])){
                return 1;
            }else
                return -1;
        }

        while (m<split2.length){
            if(Integer.valueOf(split2[m++])>0)
                return -1;
        }

        while (n<split1.length){
            if(Integer.valueOf(split1[n++])>0)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.1","1"));
        System.out.println( Integer.valueOf("001")==(Integer.valueOf("01")));
    }
}




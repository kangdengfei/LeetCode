package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 10:36
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 **/
//判读一个字符串中是否包含另外一个字符串  注意边界值的判断。
public class Implement_strStr_28 {
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length()){
            while (j<needle.length() && i < haystack.length()){
                if(haystack.charAt(i) == needle.charAt(j) ){
                    i++;
                    j++;
                }else {
                    break;
                }
            }
            if(j == needle.length()){
                return i-j;
            }else {
                i = i-j+1;
                j = 0;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        String string = "";
        String ne = "";
        System.out.println(strStr(string,ne));
    }
}




package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 21:03
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 **/
public class Excel_Sheet_Column_Number_171 {
    public static int titleToNumber(String s) {
        if(s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int temp = 0;
        for(int i = 0;i<chars.length;i++){
            temp = temp *26 + Integer.valueOf(chars[i]-64);
        }
        return temp;


    }

    public static int titleToNumberV2(String s) {
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); ++i) {
            tmp = s.charAt(i) - 'A' + 1;
            sum = 26 * sum + tmp;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCC"));
        System.out.println(titleToNumberV2("ABCC"));
        System.out.println(Integer.valueOf('B'-64));

        System.out.println('A'+1);
        System.out.println('a'+1);
    }
}




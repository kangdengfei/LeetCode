package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 18:52
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 **/
public class Excel_Sheet_Column_Title_168 {
    public  static String convertToTitle(int n) {

        String [] strings = {"A","B","C","D","E","F","G","H","I","G","K","L","M","N","O","P","Q",
        "R","S","T","U","V","W","X","Y","Z"};
        String result = "";
        while (n != 0){
            int i = (n-1)%26;
            result = strings[i]+result;
            n = (n-i) / 26;
        }
        return result;

    }

    public static String convertToTitleV2(int n) {
        if(n <= 0){
            return null;
        }
        String s = "";
        while (n != 0) {
            int temp = (n - 1) % 26;
            s =  ('A' + temp) + s;
            n = (n - 1) / 26;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(convertToTitleV2(29));
    }
}




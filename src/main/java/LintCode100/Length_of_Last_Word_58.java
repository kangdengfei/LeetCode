package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-01 11:47
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 **/
public class Length_of_Last_Word_58 {
    public static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        String[] split = s.split(" ");
        int length = split.length;
        if (length == 0)
            return 0;
        return split[length-1].length();
    }

    public static void main(String[] args) {
        String string = " ";
        System.out.println(lengthOfLastWord(string));
    }
}




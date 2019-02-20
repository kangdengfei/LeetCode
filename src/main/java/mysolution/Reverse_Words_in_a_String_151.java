package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-23 09:21
 *
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 **/
public class Reverse_Words_in_a_String_151 {

    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : split){
            stringBuilder.append(reverseWord(string)).append(" ");
        }
        return reverseWord(stringBuilder.toString().trim());
    }

    public static String reverseWord(String string){

        char[] chars = string.toCharArray();
        int len = chars.length;
        for (int i = 0;i<len/2;i++){
             char temp = chars[i];
             chars [i] =chars[len-1-i];
            chars[len-1-i] = temp;
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        String string = " a b";
        System.out.println(reverseWords(string));
    }
}




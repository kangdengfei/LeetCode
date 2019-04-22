package Leetcode350_;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-17
 *
 *  Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 **/

/*
 *解法很像逆波兰表达式的解法
 */
public class Decode_String_394 {
    public static String decodeString(String s) {
        String result = "";
        if(s== null || s.length() ==0)
            return result;
        Stack<String> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        int i = 0;
        while (i<s.length()) {

            String num = "";
            while (i< s.length() && Character.isDigit(s.charAt(i))){
                num += s.charAt(i++);
            }
            if (!num.equals("")){
                stack2.push(Integer.parseInt(String.valueOf(num)));
            }
            while ( i< s.length() &&  s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
                stack1.push(String.valueOf(s.charAt(i++)));
            }
            String temp = "";
            if (i< s.length() && s.charAt(i) == ']') {
                while (!stack1.peek().equals("[")) {
                    temp = stack1.pop() + temp;
                }
                stack1.pop();

                if (!stack2.isEmpty()) {
                    Integer pop = stack2.pop();
                    String res = "";
                    for (; pop > 0; pop--) {
                        res += temp;
                    }
                    stack1.push(res);
                }
                i++;
            }
        }

        while (!stack1.isEmpty()){
            result = stack1.pop()+result;
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        String s4 = "100[leetcode]";
        String s5 = "";
        String s7 = "3[a2[c]]";
        String s8 = "3[a]2[b4[F]c]";

        System.out.println(decodeString(s8));
    }
}




package LintCode100;

import java.util.Stack;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 17:40
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 **/
public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        if(s == null)
            return false;
        Stack<Character> stack = new Stack();
        for(int i = 0;i<s.length();i++){
            switch (s.charAt(i)){
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                default:
                    stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();

    }
}




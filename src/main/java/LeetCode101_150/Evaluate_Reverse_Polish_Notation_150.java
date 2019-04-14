package LeetCode101_150;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 09:40
 * 150. Evaluate Reverse Polish Notation
 * Medium
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 *     Division between two integers should truncate toward zero.
 *     The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 **/
public class Evaluate_Reverse_Polish_Notation_150 {
    List<String> list = Arrays.asList("+","-","*","/");
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int i = 0;
        while(i<tokens.length){
            if (list.contains(tokens[i])){
                stack.push(process(stack.pop(),stack.pop(),tokens[i]));
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }

    public Integer process(int token1,int token2,String token){

        switch (token){
            case "+":return token2+token1;
            case "-":return token2-token1;
            case "*":return token2*token1;
            case "/":return token2/token1;
            default:
                return null;
        }
    }

}




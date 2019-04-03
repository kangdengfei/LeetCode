package LeetCode201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-24 13:40
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 **/
/*
递归
 */
public class Different_Ways_to_Add_Parentheses_241 {
    public static List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0)
            return null;
        List<Integer> list = new ArrayList<>();

        for (int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String left = input.substring(0,i);
                String right  = input.substring(i+1);
                List<Integer> listl = diffWaysToCompute(left);
                List<Integer> listr = diffWaysToCompute(right);
                int temp = 0;
                for (int k : listl){
                    for (int j : listr){
                        if (c == '+'){
                            temp = k+j;
                        }
                        if (c == '-'){
                            temp = k-j;
                        }
                        if (c == '*'){
                            temp = k*j;
                        }
                        list.add(temp);//别添加错位置
                    }
                }
            }
        }
        if (list.isEmpty()){ //已经产生了递归,input只有一个值
            list.add(Integer.valueOf(input));
        }
        return list;
    }

    public static void main(String[] args) {
        String string = "2*3-4*5";
        System.out.println(string.substring(0,1));
        System.out.println(string.substring(2));
        System.out.println(diffWaysToCompute(string));

    }
}




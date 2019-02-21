package LeetCode151_200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-21 14:45
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 **/
/*
方法：将数字按照字符串进行比较，当两个数字为包含关系的时候
（例如数字80和806，则将它们连接起来比较，80806和80680，看谁大，谁就应该排在前面）。
 */
public class Largest_Number_179 {
    public static  String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        String [] strings = new String[nums.length];
        for (int i = 0;i<nums.length;i++){
            strings[i] =String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (strings[0].charAt(0) == '0'){
            return "0";
        }
        String  result = "";
        for (String s : strings){
            result= result+s;
        }
        return result;
    }

    public static void main(String[] args) {
        String [] strings = {"10","2","3","41","5"};
        int [] nums = {10,2};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o1+o2);
            }
        });
        System.out.println(Arrays.toString(strings));
        System.out.println(largestNumber(nums));

    }
}




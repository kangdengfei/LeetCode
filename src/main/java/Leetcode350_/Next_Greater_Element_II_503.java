package Leetcode350_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-17
 *
 *  Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 **/
public class Next_Greater_Element_II_503 {
    public static int[] nextGreaterElements(int[] nums) {
        int [] array = new int[nums.length];
        Arrays.fill(array, Integer.MIN_VALUE);
        for (int i =0;i<nums.length;i++){
            for (int j = i;j<nums.length;j++){
                if (nums[j]>nums[i]){

                    array[i] = nums[j];
                    break;
                }
            }
            if (array[i] == Integer.MIN_VALUE){
                for (int j = 0;j<i;j++){
                    if (nums[j]>nums[i]){
                        array[i] = nums[j];
                        break;
                    }
                }
            }
            if (array[i] == Integer.MIN_VALUE){
                array[i] = -1;
            }

        }

        return array;
    }

    public static void main(String[] args) {
        int [] array = {-1,0};
        System.out.println(Arrays.toString(nextGreaterElements(array)));

    }
}




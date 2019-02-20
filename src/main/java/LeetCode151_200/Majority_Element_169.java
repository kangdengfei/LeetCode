package LeetCode151_200;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 20:48
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 **/

/*
 *solution1: 排序 (o(nlogn))
 * solution2: hashmap (o(N)))
 * solution3:bitmap
 * solution4:分治
 *
 */
public class Majority_Element_169 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        return nums[length/2];
    }
}




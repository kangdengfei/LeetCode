package LeetCode151_200;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-19 13:30
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 **/
/*
顺序数组查找首选二分查找
 */
public class Find_Minimum_in_Rotated_Sorted_Array_153 {

    public int findMin(int[] nums) {
        if(nums == null){
            return 0;
        }
        int start = 0;
        int end = nums.length -1 ;

        while (start<end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return nums[start];

    }
}




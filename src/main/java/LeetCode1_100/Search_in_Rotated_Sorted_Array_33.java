package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 14:12
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 **/

//二分搜索的变换，左右两边分别有序
public class Search_in_Rotated_Sorted_Array_33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[left]){
                if(nums[left]<= target && nums[mid]>target){
                    right = mid -1;
                }else{
                    left = mid +1;
                }
            }else{
                if(nums[mid]<=target && nums[right] >=target){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}




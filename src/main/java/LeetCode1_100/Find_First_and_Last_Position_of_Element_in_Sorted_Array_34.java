package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 14:16
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 **/
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if (target == nums[mid]){
                start = end = mid;
                while(start -1 >= 0 && nums[start-1] == target)
                    start --;
                while(end+1 <= nums.length-1 && nums[end+1] ==target)
                    end ++;
                int []array = {start,end};
                return  array;
            }else if(target >nums[mid])
                start = mid+1;
            else
                end = mid -1;
        }
        int []array = {-1,-1};
        return array;
    }
}




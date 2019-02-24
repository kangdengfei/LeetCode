package LeetCode201_250;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 14:04
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 **/
public class Contains_Duplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null)
            return false;
        Set set = new HashSet();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}




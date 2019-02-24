package LeetCode201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 14:21
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 **/


public class Contains_Duplicate_II_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null){
            return false;
        }
        Map map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i- (int)map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i],i); //并不是if-else的关系，不存在是插入，存在时更行val;

        }
        return false;
    }

    public static void main(String[] args) {
        int [] array = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(array,1));
    }
}




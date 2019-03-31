package Leetcode250_;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-31
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 **/
public class Top_K_Frequent_Elements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Set set = new HashSet();
        for (int i :nums){
            set.add(i);
        }
        int [] array = new int[k];
    }

    public int [] create(int [] nums, int k){

    }
}




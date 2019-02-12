package LintCode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-01 16:08
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 **/
public class Subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null){
            return null;
        }
        List<List<Integer>> list = new ArrayList();
        List<Integer> combinList = new ArrayList();
        for (int i = 0;i<nums.length;i++) {
            subsets(list, combinList, nums, 0, i);
        }
        return list;
    }

    public static void subsets(List<List<Integer>> list,List<Integer> combinList,int[] nums,int start ,int len){
        if(len == 0){
            list.add(new ArrayList(combinList));
        }
        for(int i = start ;i<nums.length; i++){
            combinList.add(nums[i]);
            subsets(list,combinList,nums,i+1,len--);
            combinList.remove(combinList.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] array = {1,2,2,2};
        System.out.println(subsets(array));
    }
}




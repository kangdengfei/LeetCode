package LintCode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 15:47
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 **/
public class Subsets_II_90 {
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null){
            return null;
        }
        List list = new ArrayList();
        List<Integer> combinList = new ArrayList();
        for (int i = 0;i<nums.length;i++) {
            subsets(list, combinList, nums, 0, i);
        }
        return list;
    }

    public static void subsets(List<List<Integer>> list,List<Integer> combinList,int[] nums,int start ,int len){
        if(len == 0){
            if(!list.contains(new ArrayList(combinList))){
                list.add(new ArrayList(combinList));
            }
        }
        for(int i = start ;i<nums.length; i++){
            combinList.add(nums[i]);
            subsets(list,combinList,nums,i+1,len--);
            combinList.remove(combinList.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] array = {1,2,2};
        System.out.println(subsets(array));
    }
}




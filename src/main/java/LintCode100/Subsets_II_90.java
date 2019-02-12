package LintCode100;

import java.util.ArrayList;
import java.util.Arrays;
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

// 这题跟78 那题有掉区别 ，通过深度遍历。先将数组排序，
public class Subsets_II_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null){
            return null;
        }
        List list = new ArrayList();
        List<Integer> combinList = new ArrayList();
        Arrays.sort(nums);
//        for (int i = 0;i<nums.length;i++) {
            subsets(list, combinList, nums, 0, 0);
//        }
        return list;
    }

    public static void subsets(List<List<Integer>> list,List<Integer> combinList,int[] nums,int start ,int len){
//        if(len == 0){
//            if(!list.contains(new ArrayList(combinList))){
//                list.add(new ArrayList(combinList));
//            }
//        }
        list.add(new ArrayList(combinList));
        for(int i = start ;i<nums.length; i++){
            combinList.add(nums[i]);
            subsets(list,combinList,nums,i+1,len--);
            combinList.remove(combinList.size()-1);
            while (i<nums.length-1 && nums[i] == nums[i+1]) i++;
        }
    }

    public static void main(String[] args) {
        int [] array = {1,2,2,2};
        System.out.println(subsetsWithDup(array));
    }
}




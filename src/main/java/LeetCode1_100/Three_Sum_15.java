package LeetCode1_100;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 15:29
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 **/

//三数之和，可以提交没过，时间限制，不懂。。。
public class Three_Sum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null){
            return null;
        }
        return sum(nums,0,3);
    }


    public static List<List<Integer>> sum(int []array, int target, int len){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> per = new ArrayList<Integer>();
        Arrays.sort(array);
        com(array,target,len,0,list,per);
        return list;
    }

    public static void com(int []array,int target,int len,int start ,List<List<Integer>> list,List<Integer> per){
        if (len == 0 && target != 0 ){
            return;
        }
        if (len ==0 && target == 0){
            list.add(new ArrayList<Integer>(per));
            return;
        }
        for (int i = start;i<array.length;i++){
            per.add(array[i]);
            com(array,target-array[i],len-1,i+1,list,per);
            per.remove(per.size()-1);
            while (i < array.length - 1 && array[i] == array[i+1]) i++;
        }
    }

    /*
    先排序+加缓存 o(n2)的实际复杂度
     */
    public static List<List<Integer>> threeSumV2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i< nums.length-2;i++){
            while (i> 0 && i< nums.length-2 && nums[i] == nums[i-1]) i++;
            Set set = new HashSet();
            for (int j = i+1;j<nums.length;j++){
                int d = -(nums[i]+nums[j]);
                if (set.contains(d)) {
                    res.add(Arrays.asList(nums[i], nums[j], d));
                    while (j+1<nums.length && nums[j] == nums[j+1]) j++;
                }
                set.add(nums[j]);
            }

        }

        return res;
    }



    public static void main(String[] args) {
        int [] array = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(array));
    }
}




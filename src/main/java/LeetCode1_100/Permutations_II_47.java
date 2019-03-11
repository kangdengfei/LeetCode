package LeetCode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 16:51
 **/
public class Permutations_II_47 {
    static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        per(nums,0,nums.length);
        return lists;
    }

    public static void per(int[] nums, int start ,int end){
        if(start == nums.length){
            List<Integer>  list = new ArrayList<Integer>();
            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            lists.add(list);
            return;
        }
        for(int i = start;i<end;i++){
            if(isSwap(nums,start,i)){
                swap(nums,start,i);
                per(nums,start+1,end);
                swap(nums,i,start);
            }
        }
    }

    public static void swap(int [] a ,int i ,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSwap(int []nums,int i, int j){
        for(int m = i;m<j; m++){
            if(nums[m] == nums[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int [] array = {1,2,2};
        System.out.println(permuteUnique(array));
    }
}




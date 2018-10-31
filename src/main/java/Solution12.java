package solution1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * created  by KDF on 2017/10/24.
 * 全排列
 */


public class Solution12 {
   static List<Integer> list = new ArrayList<Integer>();
    static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permute(int[] nums) {
              per(nums,0);
        return lists;
    }


    public static void  per(int[] nums,int start){
        if(start == nums.length){
            for(int i = 0;i<nums.length;i++) {
                List<Integer> arrayList = new ArrayList<Integer>();
                arrayList.add(nums[i]);
                lists.add(new ArrayList<Integer>(list));
            }


        }else{
            for(int j = start;j<nums.length;j++){
                swap(nums,start,j);
                per(nums,start+1);
                swap(nums,start,j);
            }
        }

    }


    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }


    public static void main(String[] args) {
     int []  array = {1,2,3};
        System.out.println(permute(array));


    }


}

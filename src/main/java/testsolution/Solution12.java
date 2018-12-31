package testsolution;

import java.util.ArrayList;
import java.util.List;

/**
 * created  by KDF on 2017/10/24.
 * 全排列
 */


public class Solution12 {
//   static List<Integer> list = new ArrayList<Integer>();
    static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permute(int[] nums) {
              per(nums,0);
        return lists;
    }


    public static void  per(int[] nums,int start){
        if(start == nums.length){
            List<Integer> arrayList = new ArrayList<Integer>();
            for(int i = 0;i<nums.length;i++) {
                arrayList.add(nums[i]);
            }
            lists.add(arrayList);
        }else{
            for(int j = start;j<nums.length;j++){
                if(isSwap(nums,start,j)) {
                    swap(nums, start, j);
                    per(nums, start + 1);
                    swap(nums, start, j);
                }
            }
        }

    }


    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    public static boolean isSwap(int []nums,int i, int j){
        for(int m = i;m<j; m++){
            if(nums[i] == nums[j])
                return false;

        }
        return true;

    }


    public static void main(String[] args) {
     int []  array = {2,2,1,1};
        System.out.println(permute(array));

    }


}

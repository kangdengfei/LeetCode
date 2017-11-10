import java.util.ArrayList;
import java.util.List;

/**
 * created  by KDF on 2017/10/24.
 */


public class Solution12 {
   static List<Integer> list = new ArrayList<Integer>();
    static List<List<Integer>> list1 = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here


         per(nums,0,nums.length);

        return list1;
    }


    public static void  per(int[] nums,int start,int length){
        if(nums.length == 1){
            for(int i = 0;i<nums.length;i++)
                list.add(nums[i]);
            list1.add(list);

        }else{
            for(int j = 0;j<nums.length;j++){
                swap(nums,start,j);
                per(nums,start+1,length);
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
        permute(array);


    }


}

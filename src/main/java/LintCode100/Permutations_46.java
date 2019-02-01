package LintCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 16:46
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 **/
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null){
            return null;
        }
        List list = new ArrayList();
        combition(nums,0,nums.length,list);
        return list;
    }

    public  void combition(int [] str,int start,int len,List<List<Integer>> list){
        if(start == len){
            List combList = new ArrayList();
            for(int i = 0;i<str.length;i++){
                combList.add(str[i]);
            }
            list.add(new ArrayList(combList));
            System.out.println(Arrays.toString(str));
        }else{
            for(int i=start;i<len;i++){
                swap(str,start,i);
                combition(str,start+1,len,list);
                swap(str,start,i);

            }
        }
    }

    public void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}




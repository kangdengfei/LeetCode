package testsolution;

import java.util.Scanner;

/**
 * created  by KDF on 2017/12/11.
 * 给一整数数组, 用当前元素之后数组中的最大元素来替换当前元素(右侧的最大元素).
 * 因为最后一个元素的右边没有元素了, 所以用 -1 来替换这个值.
 * 举个例子, 如果数组为 [16,17,4,3,5,2], 那么它就需要修改为 [17,5,5,5,2,-1].

 样例：
 给出数组 nums = [16,17,4,3,5,2], 改变数组为 [17,5,5,5,2,-1], 你需要在原地实现。
 */


public class Solution26 {
    public static void arrayReplaceWithGreatestFromRight(int[] nums){
        int len = nums.length;
        int temp = nums[len-1];
        nums[len-1] = -1;
        for(int i = len-2;i>=0;i--){
            int m = temp;
            if(nums[i] > temp){
                temp = nums[i];
            }
            nums[i] = m;
        }
        for(int i = 0;i<nums.length;i++)
        System.out.print(nums[i]+" ");
    }

    public static void main(String[] args) {
        int [] array = {16,17,4,3,5,2};
        arrayReplaceWithGreatestFromRight(array);

    }

}

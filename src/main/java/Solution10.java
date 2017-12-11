package solution1_20;

/**
 * created  by KDF on 2017/10/23.
 * 问题是这样的：一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，
 * 要求该连续子数组中各元素的和最大，这个连续子数组便被称作最大连续子数组。
 * 比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，最大连续子数组的和为5+2-1+2=8
 */


public class Solution10 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = array[0];
        for(int i = 1;i<array.length;i++){
            if(sum>=0)
            sum += array[i];
            else
                sum = array[i];
            if(sum >max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int []array = {2,4,-7,5,2,-1,2,-4,3};
        int max =FindGreatestSumOfSubArray(array);
        System.out.println(max);
    }

}

package LeetCode1_100;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 14:39
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 *
 *     The number of elements initialized in nums1 and nums2 are m and n respectively.
 *     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 **/
public class Merge_Sorted_Array_88 {
    //这个自己写的太乱了需要整理思路
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null){
            return;
        }
        int i = 0;
        int j = 0;
        while (m > 0){
            //nums2[j]<nums1[i]往nums1上合并
            if (nums1[i]>nums2[j] ){
                //从i开始向后移动
                for (int k=nums1.length-1;k > i; k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
                n--;
                m++;
            }
            i++;
        }

        while (m<nums1.length){
            nums1[m-1]=nums2[j];
            m++;
        }

    }

    //从后向前合并
    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null){
            return;
        }
        while (m>0 && n>0){
            if(nums1[m-1] < nums2[n-1]){
                nums1[n+m-1] = nums2[n-1];
                n--;
            }else {
                nums1[n+m-1]=nums1[m-1];
                m--;
            }

        }
        while (n>0){
            nums1[n+m-1] = nums2[n-1];
            n--;
        }
    }
    public static void main(String[] args) {
        int [] array1 = {4,5,6,0,0,0};
        int [] array2 = {1,2,3};
        mergeV2(array1,3,array2,3);
        System.out.println(Arrays.toString(array1));
    }
}




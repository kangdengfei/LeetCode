package Leetcode250_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-30
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 **/
public class Intersection_of_Two_Arrays_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i <nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else
                i++;
        }

        Integer[] objects = (Integer[]) set.toArray(new Integer[set.size()]);
        int[] target = new int[set.size()];
        for (int k = 0;k<objects.length;k++){
            target[k] = objects[k];
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};

        int[] nums2 =  {2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
}




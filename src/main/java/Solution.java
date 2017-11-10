/**
 * created  by KDF on 2017/10/19.
 */
/*
题目描述：给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。

样例：给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 */

public class Solution {
    public static int getMax(int []array){
        int sum =0;
        int result =0;
        for(int i=0;i<array.length;i++){
            sum =sum+array[i];
            if(sum<0){
                sum = 0;

            }else  if(sum >result){
                result = sum;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [] a={-2,2,-3,4,-1,2,1,-5,3,};
        System.out.println(getMax(a));
    }
}

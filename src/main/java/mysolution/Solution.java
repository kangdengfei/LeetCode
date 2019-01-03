package mysolution;

/**
 * created  by KDF on 2017/10/19.
 */
/*
题目描述：给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。

样例：给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 */

public class Solution {
    /**
     * 这个方法是错的
     * @param array
     * @return
     */
    @Deprecated
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

    public static  int getMax2(int [] array){
        int max=  Integer.MIN_VALUE;
        int sum = 0 ;
        for(int i = 0; i<array.length;i++){
            sum += array[i];
            max = Math.max(max,sum);
            if (sum <0)
                sum = 0;
        }
        return max;
    }


    public static int getMax3(int[] array){
        int sum = array[0];

        for (int i = 1;i<array.length;i++){
            if (array[i]>0){
                sum+=array[i];
            }
        }
          return 0;
    }
    public static void main(String[] args) {
        int [] a={-1,-2,-3};
        int [] a2 = {-2,2,-3,4,-1,2,1,-5,3};
        System.out.println(getMax(a2));
        System.out.println(getMax2(a2));
    }
}

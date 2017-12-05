import java.util.ArrayList;

/**
 * created  by KDF on 2017/12/5.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */


public class Solution24 {
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length<2){
            return list;
        }
        int i = 0;
        int j = array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum)
                j--;
            else
                i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {11,13,15,16,17,18,19,21,25,26,27,31,42,43};
        ArrayList<Integer> arrayList = findNumbersWithSum(array,40);
        System.out.println(arrayList);
    }
}


package testsolution;

/**
 * created  by KDF on 2017/10/19.
 */

/*
假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
给出一个数组样例 [3,2,3,1,2], 返回 1
 */

public class Solution7 {
    public  static int getMax(int []array){
        int temp;
        int min = array[0];
        int result = 0;
        for(int i=1;i<array.length;i++){

            if(min>array[i]){
                min = array[i];
            }else {
                temp = array[i]-min;
                if(temp >result)
                    result = temp;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int []a = {3,2,3,1,2,6};
        int re =getMax(a);
        System.out.println(re);
    }
}

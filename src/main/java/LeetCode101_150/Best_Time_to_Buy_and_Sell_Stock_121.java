package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-14 16:05
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 **/

/*
当前价格与前i天价格的最最小值的差，与result 比较，去最大的。
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int temp = prices[0];
        int result = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i]<temp){
                temp = prices[i];
            }
            result = Math.max(result,prices[i]-temp);
        }
        return result;
    }
}




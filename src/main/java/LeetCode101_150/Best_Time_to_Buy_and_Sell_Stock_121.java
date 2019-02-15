package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-14 16:05
 **/
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




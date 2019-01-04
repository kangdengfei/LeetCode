package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-11-05 15:52
 **/
public class LISSolution {

    public static int getMaxlength(int[]array){
        int []dp = new int [array.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 1;i<array.length;i++){
            if (array[i]>array[i-1])
                dp[i] = dp[i-1]+1;
            else
                dp[i] = 1;

            max = max>dp[i]?max:dp[i];
        }
        return max;
    }

    //l两种不同的题目解法
    public static int getMaxlengthV2(int[] array){
        int max = 1;
        int [] dp = new int [array.length];
        dp [0] =1;
        for (int i = 1 ;i <array.length;i++){
            for (int j = 0;j<i;j++){
                if (array[i]>array[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int [] array = {2,4,3,5,1,6};
        int maxlength = getMaxlength(array);
        System.out.println(maxlength);
        System.out.println(getMaxlengthV2(array));
    }
}




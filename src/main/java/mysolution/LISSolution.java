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

    public static void main(String[] args) {
        int [] array = {4,5,2,3,9,1,6,7,11,8,10};
        int maxlength = getMaxlength(array);
        System.out.println(maxlength);
    }
}




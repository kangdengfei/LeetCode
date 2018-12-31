package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-05 15:07
 *
 * [3,2,1,4,5]
 **/
public class Jump {
    public static int jump(int[]array){
        if (array == null || array.length==0)
            return 0;
        int next = 0;
        int jump = 0;
        int cur = 0;
        for (int i = 0;i<array.length;i++) {
            if (cur < i) {
                jump ++;
                cur = next;
            }
            next = Math.max(next,array[i]+i);
        }
        return jump;
    }


    public static int jump2(int [] array){
        if (array == null || array.length==0)
            return 0;
        int dp [] = new int[array.length];//到第i个点需要的步数
        dp[0] = 0;
        int max = array[0];
        int cur = 0;
        for (int i = 1;i<array.length;i++){
            if (max < i){
                return  -1;
            }
            if (cur<i){
                dp[i] = dp[i-1]+1;
                cur = max;
            }
            else
                dp[i] = dp [i-1];
            max = Math.max(max,array[i]+i);
        }
        return dp[array.length-1];
    }


    public static void main(String[] args) {
        int [] array = {1,2,1,0,0,1,5};
        System.out.println(jump(array));
        System.out.println(jump2(array));
        System.out.println(jump3(array));
    }

    /**
     * 给出一个数组看能否跳到末尾
     */
    public static boolean jump3(int []array){
        int max = 0;
        for (int i=0;i<array.length;i++){
            if (max<i)
                return false;
            max = Math.max(max,array[i]+i);
        }
        return true;
    }
}




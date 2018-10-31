package solution1_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created  by KDF on 2017/10/10.
 * 给你六种面额1、5、10、20、50、100元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
 */


public class  Solution6 {
    public static int[] moneys = {1,5,10,20,50,100};

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            int n = scanner.nextInt();
//            int[] moneys = {1,5,10,20,50,100};
//            long[] dp = new long[n+1]; //dp[i]代表拼凑i元的方法数
//            dp[0] = 1;
//            for(int i=0;i<moneys.length;i++){
//                for(int j=1;j<=n;j++){
//                    if(j >= moneys[i]){
//                        dp[j]+= dp[j-moneys[i]];
//                    }
//                }
//            }
//            System.out.println(dp[n]);
//            System.out.println(--);
//
//        }
//
        int dfs = DFS(moneys, 0, 18);
        System.out.println(dfs);
        System.out.println("---");
        old(18);

    }

    public static  int total;
    public static List<Integer> list = new ArrayList<Integer>();
    public static int DFS(int []a, int start , int target){
        if(target < 0) return 0;
        if (target == 0){
            System.out.println(list);
            total++;
        }
        for (int i = start; i < a.length; i++){
            list.add(a[i]);
            DFS(a,i,target-a[i]);
            list.remove(list.size()-1);
        }
        return total;
    }


  public static void old(int target){

      long[] dp = new long[target+1]; //dp[i]代表拼凑i元的方法数
      dp[0] = 1;
      for(int i=0;i<moneys.length;i++){
          for(int j=1;j<=target;j++){
              if(j >= moneys[i]){
                  dp[j]+= dp[j-moneys[i]];
              }
          }
      }
      System.out.println(dp[target]);

  }

}

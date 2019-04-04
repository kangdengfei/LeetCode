package testsolution;

import java.util.ArrayList;
import java.util.List;


/**
 * created  by KDF on 2017/10/10.
 * 给你六种面额1、5、10、20、50、100元的纸币，
 * 假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
 */


public class  Solution6 {
    public static int[] moneys = {1,5,10};

    static int tot =0;
    public static void main(String[] args) {

        int total = 0;
        DFS(moneys, 0, 5,total);
        System.out.println(total);
        System.out.println("---");
        old(5);
        System.out.println(tot);
        System.out.println(lists);

    }


    /*
    深度遍历
     */
    public static List<Integer> list = new ArrayList<Integer>();
    public  static List<List<Integer>> lists = new ArrayList<>();
    public static void  DFS(int []a, int start , int target,int total){
        if(target < 0) return ;
        if (target == 0){
            tot++;
            lists.add(new ArrayList<Integer>(list));
        }
        for (int i = start; i < a.length; i++){
            list.add(a[i]);
            DFS(a,i,target-a[i],total);
            list.remove(list.size()-1);
        }
    }


    /*
    动态规划
     */
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

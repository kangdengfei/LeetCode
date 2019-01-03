package mysolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-31 11:29
 *
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 **/
public class Combinations_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList();
        combine(combs,new ArrayList<Integer>() ,1,n,k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs,List<Integer> list,int statr ,int n ,int k){
        if (k == 0){
            combs.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = statr;i<=n;i++){
            list.add(i);
            combine(combs,list,i+1,n,k-1);
            list.remove(list.size()-1);
        }
    }


//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> combs = new ArrayList<List<Integer>>();
//        combine(combs, new ArrayList<Integer>(), 1, n, k);
//        return combs;
//    }
//    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
//        if(k==0) {
//            combs.add(new ArrayList<Integer>(comb));
//            return;
//        }
//        for(int i=start;i<=n;i++) {
//            comb.add(i);
//            combine(combs, comb, i+1, n, k-1);
//            comb.remove(comb.size()-1);
//        }
//    }



    public static void main(String[] args) {
        int k = 3;
        for (int i = 1;i<=k;i++)
            System.out.println(combine(4,i));
    }
}




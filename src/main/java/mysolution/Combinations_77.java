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
    static int totoal = 0;
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList();
        combine(combs,new ArrayList<Integer>() ,1,n,k);
//        System.out.println(totoal);
        System.out.println("------");
        return combs;
    }

    public static void combine(List<List<Integer>> combs,List<Integer> list,int statr ,int n ,int k){
        if (k == 0){
            combs.add(new ArrayList<Integer>(list));
            totoal++;
            return;
        }
        for (int i = statr;i<=n;i++){
            list.add(i);
            combine(combs,list,i+1,n,k-1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int k = 4;
        for (int i = 1;i<=4;i++)
            System.out.println(combine(4,i));
        System.out.println(totoal);
    }
}




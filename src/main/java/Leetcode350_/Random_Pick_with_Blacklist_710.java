package Leetcode350_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-05-06
 *
 * Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.
 *
 * Optimize it such that it minimizes the call to system’s Math.random().
 *
 * Note:
 *
 *     1 <= N <= 1000000000
 *     0 <= B.length < min(100000, N)
 *     [0, N) does NOT include N. See interval notation.
 *
 * Example 1:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 *
 * Example 2:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * Output: [null,1,1,1]
 *
 * Example 3:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 *
 * Example 4:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * Output: [null,1,3,1]
 **/
public class Random_Pick_with_Blacklist_710 {
    private int n;
    private int[] array;
    private List list;

    public Random_Pick_with_Blacklist_710(int N, int[] blacklist) {
        this.n = N;
        this.array = blacklist;
        list = new ArrayList();
        for(int i : blacklist){
            list.add(i);
        }
    }

    public int pick() {
        Random random = new Random();
        int res = random.nextInt(n);
        while (list.contains(res)){
            res = random.nextInt(n);
        }
        return res;
    }
}




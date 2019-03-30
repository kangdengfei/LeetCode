package LeetCode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-15 14:07
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 **/

public class Combination_Sum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        combinationSum(list,new ArrayList<Integer>(),0,target,candidates.length,candidates);
        return list;
    }

    public void combinationSum(List<List<Integer>> list ,List<Integer> comList,int start,int sum,int len,int[] candidates){
        if(sum<0)
            return;
        if(sum == 0){
            list.add(new ArrayList(comList));
            return;
        }
        for(int i = start ;i<len ;i++){
            comList.add(candidates[i]);
            combinationSum(list,comList,i,sum-candidates[i],len,candidates);
            comList.remove(comList.size()-1);
        }
    }
}




package LintCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 14:45
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * LeetCode 39. Combination Sum —— 组合总和的升级版。还是想象成图来帮助理解。和第39题相比本题有两个变化。第一，本题有重复节点；第二，每个节点只能用一次，即没有自环。结合对39代码注释的理解，稍稍更改即可得到本题的解题思路：
 *
 * 如何处理自环问题？每次搜索新路径的时候都从其下一个节点开始，而不是从它本身开始；
 *
 * 如何处理去重问题？每次回溯的时候，刚刚被剔除的节点不能在任何时候再被重新加入到路径上。如何处理这个“任何时候”呢？要么用map标记被剔除的节点直到路径搜索结束，要么应用排序，将所有有相同出权值的节点都放到一起，这样可以方便找到下一个出权值不同的节点。
 **/
public class Combination_Sum_II_40 {

    //组合会重复
    @Deprecated()
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null)
            return null;
        List<List<Integer>> list = new ArrayList();
        List<Integer> combList = new ArrayList();
        Arrays.sort(candidates);
        combinationSum2(list,combList,candidates,target,0);
        return list;
    }

    public void combinationSum2(List<List<Integer>> list,List<Integer> combList,int[] candidates, int target,int start) {
        if(target == 0){
            list.add(new ArrayList(combList));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start;i<candidates.length;i++){
            combList.add(candidates[i]);
            combinationSum2(list,combList,candidates,target-candidates[i],i+1);
            combList.remove(combList.size()-1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i+1]) i++;
        }
    }
}




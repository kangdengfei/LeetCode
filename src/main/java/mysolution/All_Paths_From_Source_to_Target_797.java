package mysolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-24 11:51
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 **/
/*
深度遍历 DFS
 */
public class All_Paths_From_Source_to_Target_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length ==0)
            return null;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        allPath(lists,list,graph.length-1,0,graph);
        return lists;
    }

    public void allPath(List<List<Integer>> lists,List<Integer> list ,int target,int temp,int[][] graph){
        if(temp == target){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i :graph[temp]){
            list.add(i);
            allPath(lists,list,target,i,graph);
            list.remove(list.size()-1);
        }
    }


    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        if (graph == null || graph.length == 0){
            return null;
        }
        List<List<Integer>> list = new ArrayList();
        List combinList = new  ArrayList<>();
        combinList.add(0);
        allPathsSourceTarget2(0,graph.length-1,graph,combinList,list);
        return list;
    }

    public void allPathsSourceTarget2(int start,int end,int[][] graph,List<Integer> combinList,List<List<Integer>>list){
        if (start == end){
            list.add(new ArrayList(combinList));
        }
        for (int i = 0;i<graph[start].length;i++){
            combinList.add(graph[start][i]);
            allPathsSourceTarget2(graph[start][i],end,graph,combinList,list);
            combinList.remove(combinList.size()-1);
        }
    }

}




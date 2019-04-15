package LeetCode201_250;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 12:36
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 *
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 *
 * Note:
 *
 *     The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *     You may assume that there are no duplicate edges in the input prerequisites.
 **/
/*
BFS 广度遍历
 */
public class Course_Schedule_II_210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            int[] a = new int[numCourses];
            for(int i = 0;i<numCourses;i++){
                a[i]  = i;
            }
            return a;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        int [] degree = new int[numCourses];//当 前点的入度
        int []result = new int[numCourses];
        for (int [] a : prerequisites){
            degree[a[0]]++;
            if (map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(a[0]);
                map.put(a[1],list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = numCourses;
        for (int i = 0;i<degree.length;i++){
            if (degree[i] == 0){
                queue.offer(i);
                count--;
            }
        }
        int order = 0;
        while (!queue.isEmpty()){
            int num = (int)((LinkedList<Integer>) queue).pop();
            result[order++] = num;
            List<Integer> list = map.get(num);
            if (list != null) {
                for (int i : list) {
                    degree[i]--;
                    if (degree[i] == 0) {
                        queue.offer(i);
                        count--;
                    }
                }
            }
        }
        if(count == 0) return result;
        int [] a = new int[0];
        return a;

    }




    public static void main(String[] args) {
        int [][] array ={{0,1}};
        System.out.println(Arrays.toString(findOrder(2,array)));
        List list = new ArrayList(3);
        System.out.println(list.size());

    }

}




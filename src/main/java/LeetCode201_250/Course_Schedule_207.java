package LeetCode201_250;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-22 12:44
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 * Note:
 *
 *     The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *     You may assume that there are no duplicate edges in the input prerequisites.
 **/
/*
入度 顶点的入读：指向该顶点的边的总数
出度 顶点的出度：该顶点指出的边的总数

再用一个map，key为被依赖的节点，val为依赖key节点的所有节点的list。当key节点被加入到可访问到队列时，
遍历所有val节点，看这些节点因为key节点的可访问是否满足了访问条件，也就是它们还有没有别的依赖。
 */
public class Course_Schedule_207 {
    public static Map canFinish(int numCourses, int[][] prerequisites) {
         int [] visit = new int[numCourses];
        HashMap<Integer,List<Integer>> hashMap = new HashMap();
        System.out.println(Arrays.toString(visit));

        for(int i = 0; i<numCourses;i++){
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0;j<numCourses;j++){
                if(prerequisites[i][j] ==1){
                    list.add(j);
                }
                hashMap.put(i,list);
            }
        }
        return hashMap;
    }

    public boolean canFinshDFS(HashMap hashMap,int [] array,int i){
        if (array[i] ==  -1)
            return false;
        if (array[i] == 1){
            return true;
        }
        if(hashMap.containsKey(i)){
            List<Integer> list = (ArrayList) hashMap.get(i);
            if(list != null && list.size() != 0){
                //看依赖他的点是否可访问，是继续
                for (int k = 0; k<list.size();k++){
                    return canFinshDFS(hashMap,array,list.get(k).intValue());
                }
            }

        }
        array[i] = 1;
        return true;
    }


    /**
     * BFS 基于入度
     * 每一层都是找出当前不需要prerequisite的课程，即等级为0的课程，当扫到这门课里，
     * 把其他需要这门课作为prerequisite的课降一个等级，直到其等级为0时，
     * 把它存到queue中作为其他课程可用的prerequisite课。
     * 同时记录一共存了多少课程在queue里，这些课都是可以上的课。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishV2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        if (prerequisites.length == 0 || prerequisites[0].length == 0) return true;

        ArrayList[] graph = new ArrayList[numCourses];//当、
        int[] degree = new int[numCourses];//每门课程的入读
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] course : prerequisites) {
            degree[course[0]]++; //这个点入度
            graph[course[1]].add(course[0]);
        }

        //BFS
        Queue<Integer> q = new LinkedList<>();
        int courseRemaining = numCourses;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                courseRemaining--; // 存在依赖的点
            }
        }
        //Search one and get rid of this one for the all
        while(!q.isEmpty()) {
            int key = q.poll();
            for (int i = 0; i < graph[key].size(); i++) {
                int course = (int)graph[key].get(i);
                degree[course]--;
                if (degree[course] == 0) {
                    q.offer(course);
                    courseRemaining--;
                }
            }
        }

        return courseRemaining == 0;
    }
    public static void main(String[] args) {
        int [][] array = {{0,1,1,1},{0,0,0,0},{0,0,0,1},{0,0,0,0}};
        System.out.println(canFinish(4,array));
    }
}




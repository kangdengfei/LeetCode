package mysolution;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-22 15:54
 **/
public class Test {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1 || prerequisites == null){
            return true;
        }
        int [] degree = new int [numCourses];
        List<List<Integer>> list = new ArrayList();
        for(int i = 0;i<numCourses;i++){
            list.add(new ArrayList());
        }

        for(int [] a: prerequisites){
            degree[a[0]]++;
            list.get(a[1]).add(a[0]);
        }
        Queue<Integer> q = new LinkedList();
        int count = numCourses;
        for(int i = 0;i<numCourses;i++){
            if(degree[i] == 0){
                q.offer(i);
                count--;
            }
        }

        while(!q.isEmpty()){
            int temp = (int) ((LinkedList<Integer>) q).pop();
            List tempList = list.get(temp);
            for(int i = 0;i<tempList.size();i++){
                int course = (int) tempList.get(i);
                int s = degree[course]-1;
                degree[course] = s;
                if(s == 0){
                    count--;
                    q.offer(course);
                }

            }

        }
        return count == 0;
    }
    public static void main(String[] args) {
        Test test = new Test();
        int [][] array = {{0,1,1,1},{0,0,0,0},{0,0,0,1},{0,0,0,0}};
        int [][] array1 = {{1,0}};
        int [][] array2 = {{2,0},{2,1}};
        System.out.println(test.canFinish(3,array2));
    }
}




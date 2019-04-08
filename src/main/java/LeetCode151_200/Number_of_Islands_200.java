package LeetCode151_200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-08
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 **/
public class Number_of_Islands_200 {
    public int [] row = {1,-1,0,0};
    public int [] col = {0,0,1,-1};
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int count = 0;
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == '1'){
                    DFS(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char[][] grid,int i,int j){
        //递归终止条件
        if (i < 0 || i >= grid.length || j < 0 || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }else if (grid[i][j] == '1'){
            grid[i][j] = '0';
        }

         //处理逻辑

        //递归
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);
    }





    public int numIslandsV2(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int count = 0;
        LinkedList linkedList = new LinkedList();
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == '1'){
                    linkedList.offer(new int[]{i,j});
                    BFS(linkedList,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void BFS(LinkedList<int []> queue,char[][] grid){
        while (!queue.isEmpty()){
            int[] pop = queue.pop();
            grid[pop[0]][pop[1]] = '0';
            for(int i = 0;i<4;i++){
                int m = pop[0] + row[i];
                int n = pop[1] + col[i];
                if (m>=0 && m< grid.length && n >= 0 && n<grid[0].length && grid[m][n] == '1'){
                    queue.offer(new int []{m,n});
                }
            }

        }
    }



}




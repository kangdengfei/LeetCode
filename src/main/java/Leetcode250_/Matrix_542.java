package Leetcode250_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-18
 *
 *  Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 * Input:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * Output:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * Example 2:
 * Input:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * Output:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * Note:
 *
 *     The number of elements of the given matrix will not exceed 10,000.
 *     There are at least one 0 in the given matrix.
 *     The cells are adjacent in only four directions: up, down, left and right.
 **/
/*
广度遍历
 */
public class Matrix_542 {
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null){
            return null;
        }
        Queue<int[]> queue = new LinkedList();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    queue.offer(new int[] {i,j});
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int [][] array = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            int [] cell =((LinkedList<int[]>) queue).pop();
            for (int [] arr : array){
                int rol = cell[0] + arr[0];
                int cow = cell[1] + arr[1];
                if (rol <0 || rol >=m || cow <0 || cow>=n || matrix[rol][cow] <= matrix[cell[0]][cell[1]] +1) continue;
                else {
                    matrix[rol][cow] = matrix[cell[0]][cell[1]] +1;
                    queue.offer(new int[]{rol,cow});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int [][] array = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(updateMatrix(array));
    }
}




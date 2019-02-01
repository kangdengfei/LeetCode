package LintCode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-01 11:03
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 **/

//后面两个if 判断很重要
public class Spiral_Matrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null ){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        if( matrix.length == 0){
            return list;
        }
        int rawstart = 0;
        int rawend = matrix.length-1;
        int colstart = 0;
        int colend = matrix[0].length-1;

        while(rawstart <= rawend && colstart <= colend){
            for(int i = colstart;i<=colend;i++){
                list.add(matrix[rawstart][i]);
            }
            rawstart++;
            for (int i = rawstart;i<=rawend;i++){
                list.add(matrix[i][colend]);
            }
            colend--;
            if(rawstart <= rawend){
                for (int i = colend ;i>=colstart;i--){
                    list.add(matrix[rawend][i]);
                }
            }
            rawend--;
            if(colstart <= colend){
                for (int i = rawend;i>=rawstart;i--){
                    list.add(matrix[i][colstart]);
                }
            }
            colstart++;
        }
        return list;
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(spiralOrder(matrix));
    }
}




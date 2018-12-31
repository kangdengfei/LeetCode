package testsolution;

import java.util.ArrayList;
import java.util.List;

/**
 * created  by KDF on 2017/11/13.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */


public class Solution17 {

    public static void printMatrix(int [][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int boom = matrix.length-1;
        while((left<right)&&(top<boom)){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
        }
        for(int i = top+1;i<=boom;i++){
                list.add(matrix[i][right]);
        }
        for(int i = right-1;i>=left;i--){
            list.add(matrix[boom][i]);
        }
        for(int i = boom-1;i>top;i--){
            list.add(matrix[i][left]);
        }
        left++;
            right--;
            top++;
            boom--;
        }
        if((top<=boom)&&(left<right)){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
            }
        }
        if((left<=right)&&(top<boom)){
            for(int i=top;i<boom;i++){
                list.add(matrix[i][left]);
            }
        }
        if((left==right)&&(top==boom)){
            list.add(matrix[left][top]);
        }
      //  return list;
        for (Integer list1:list){
            System.out.print(list1+"  ");
        }
    }


    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(array);

    }


}

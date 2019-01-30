package mysolution;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-23 14:21
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 **/
public class Spiral_Matrix_II_59 {
    public static int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int k = 0;
        int colStart = 0;
        int colEnd = n - 1;
        int rawStart = 0;
        int rawEnd = n - 1;
        int total = n * n;
        while (k < total) {
            for (int i = colStart; i <= colEnd; i++) {
                a[rawStart][i] = ++k;
            }
            rawStart++;
            for (int i = rawStart; i <= rawEnd; i++) {
                a[i][colEnd] = ++k;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                a[rawEnd][i] = ++k;
            }
            rawEnd--;
            for (int i = rawEnd; i >= rawStart; i--) {
                a[i][colStart] = ++k;
            }
            colStart++;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println((generateMatrix(3)));
    }

}




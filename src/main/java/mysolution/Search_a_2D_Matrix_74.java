package mysolution;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-11-07 15:24
 **/
public class Search_a_2D_Matrix_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;// 行
        int col = matrix[0].length;//列

        int i = 0;
        int j = col-1;
        while (i<row && j>=0){
            if (matrix[i][j] ==target)
                return true;
            else if (matrix[i][j]>target)
                j--;
            else
                i++;

        }
        return false;

    }

    public static void main(String[] args) {
        int [][] array= {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(array.length);
        System.out.println(array[0].length);
        System.out.println(searchMatrix(array,13));
        Set set = new HashSet();
        set.add(1);
        set.add(1);

    }
}




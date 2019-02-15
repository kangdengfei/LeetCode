package LeetCode101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-13 11:57
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 **/
public class Pascals_Triangle_II_119 {
    public List<Integer> getRow(int rowIndex) {
       int numRows = rowIndex+1;
        if (numRows <0){
            return null;
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int k = 0;
        while(k < numRows){
            List<Integer> list = new ArrayList<Integer>();
            if (k == 0){
                list.add(1);
            }else if (k ==1){
                list.add(1);
                list.add(1);
            }else {
                List<Integer> list1 = lists.get(lists.size() - 1);
                list.add(1);
                int j = 0;
                for (int i = 0;i<=k-2;i++){
                    list.add(list1.get(j)+list1.get(j+1));
                    j++;
                }
                list.add(1);
            }

            lists.add(new ArrayList<Integer>(list));
            k++;
        }
        return lists.get(numRows-1);
    }

}




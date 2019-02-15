package LeetCode101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-13 09:21
 *
 * 118. Pascal's Triangle
 * Easy
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 **/
public class Pascals_Triangle_118 {
    public List<List<Integer>> generate(int numRows) {
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
        return lists;
    }
}




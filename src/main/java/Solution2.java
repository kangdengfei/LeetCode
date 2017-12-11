package solution1_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created  by KDF on 2017/9/29.
 */


public class Solution2 {
    public static void  subsetsWithDup(int[] num) {
        Set<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>();
//        List<List<Integer>> result =new ArrayList<List<Integer>>();
        for(int i= 0;i<num.length;i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j=i;j<num.length;j++){
                list.add(num[j]);
//                System.out.println(list);
                s.add(new ArrayList<Integer>(list));
            }
        }
        System.out.println(s);
        System.out.println("......");
        for(ArrayList<Integer> s1:s)
            System.out.print(s1);

    }

    public static void main(String[] args) {
       int arry[] ={1,2,2};
     subsetsWithDup(arry);
    }

}

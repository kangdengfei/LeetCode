package testsolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-16 16:13
 *
 *
 * n 数之和
 **/
public class TreeNumberSum {
    public static List<List<Integer>> sum(int []array,int target,int len){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> per = new ArrayList<Integer>();
        com(array,target,len,0,list,per);
        return list;
    }

    public static void com(int []array,int target,int len,int start ,List<List<Integer>> list,List<Integer> per){
        if (len ==0 && target == 0){
            list.add(new ArrayList<Integer>(per));
            return;
        }
        if (len == 0 && target != 0 ){
            return;
        }
        for (int i = start;i<array.length;i++){
            per.add(array[i]);
            com(array,target-array[i],len-1,i+1,list,per);
            per.remove(per.size()-1);
        }

    }

    public static void main(String[] args) {
        int [] array = {-1, 0, 1, 2, -1, -4};
        System.out.println(sum(array,0,3));
    }
}




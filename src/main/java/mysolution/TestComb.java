package mysolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-16
 **/
public class TestComb {
    public static int total =0;



    public static void combition(List<Integer> target,List<Integer> integerList,int start,int len,List<List<Integer>> list){
       list.add(new ArrayList<>(integerList));
       for (int i = start;i<len;i++){
           integerList.add(target.get(i));
           combition(target,integerList,i+1,len,list);
           integerList.remove(integerList.size()-1);
       }

    }

    public static void main(String[] args) {
        String[] st = {"1","2","3"};
        List<List<Integer>> list = new ArrayList();
        combition(Arrays.asList(1,2,3),new ArrayList<>(),0,3,list);
        System.out.println(list);
        System.out.println(total);
    }
}




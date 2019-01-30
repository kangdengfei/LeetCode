import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-10-29 13:49
 **/
public class MyCombination {

    public static List<Integer> list = new ArrayList<Integer>();
    public static void DFS(int []a, int start,int temp){
        if (temp <0) return;
        if(temp == 0){
            System.out.println(list);
//            list.clear();
//            return;
        }
        for (int i=start;i<a.length;i++){
            list.add(a[i]);
            DFS(a,i+1,temp-a[i]);//数字可以重复
//            DFS(a,i+1,temp-a[i]);//数字不可以重复
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] array = {1,5,2};
//        int [] array = {2,3,4,7};
        DFS(array,0,8);
        System.out.println(list.size());
    }
}




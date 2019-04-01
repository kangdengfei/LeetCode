package testsolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-10-28 14:54
 **/
public class Solution40 {

    static char [] a = new char[3];
    static boolean []booleans = {false,false,false};// 第i为没有放数
    static boolean [] b = new boolean[3];

    public static void DFS(int step,int n ,char [] array){
        //选择自己的终止条件
        if(step == n +1){
            System.out.println(a);
            return;
        }
        for(int i = 0; i < n; i++){
            if(booleans[i] == false){
                a[step-1] = array[i];
                booleans[i] = true;
                DFS(step+1,n,array);
                booleans[i] = false;
            }

        }
        return;
    }


    public static void DFS2(char []a ,int start, int index){
        if(start == index){
            for (int i = 0;i<a.length;i++){
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }
        for(int i = start; i<a.length;i++){
            swap(a,start,i);
            DFS2(a,start+1,index);
            swap(a,i,start);
        }

    }


    public static void swap(char []a,int i ,int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 有问题
     * @param
     * @param
     * @param
     */
    private static List<Character> list = new ArrayList<Character>();
    public static void DFS3(char []a,int start,int len){
        if(list.size()>len) return;
        if (list.size() == len){
            System.out.println(list);
        }
        for (int i = 0;i<a.length;i++){
            if (list.contains(a[i])){
                continue;
            }
            list.add(a[i]);
            DFS3(a,i+1,len);
            list.remove(list.size()-1);
        }
    }



    public static void main(String[] args) {
         char [] array = {'a','b','c'};
        DFS(1,array.length,array);
        System.out.println("----------");
        DFS2(array,0,array.length);
        System.out.println("----------");
//        DFS3(array,0,array.length);
    }
}




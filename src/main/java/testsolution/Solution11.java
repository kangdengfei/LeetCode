package testsolution;

import com.sun.javafx.collections.ListListenerHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * created  by KDF on 2017/10/23.
 * 全组合
 *
 */



public class Solution11 {
    void combination(String s) {
        char[] strs = s.toCharArray();
        int n = s.length();
        int nbit = 1 << n;
        int count =0;
        for (int i = 0; i < nbit; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j; // 由0到n右移位
                if ((tmp & i) != 0) { // 与运算，同为1时才会是1
                    System.out.print(strs[j]);
                }
            }
            System.out.println();
        }
        System.out.println("结果数为:" + (nbit - 1));
    }

    public static void combinationV2(String s) {
        int n = s.length();
        int nbit = 1 << n;
        List res = new ArrayList();
        for (int i = 0;i<nbit;i++){
            List list = new ArrayList();
            int temp = 0;
            int j = i;
             while (j != 0){
                 if ((j & 1) != 0){
                     list.add(s.charAt(temp));
                 }
                 temp++;
                 j = j>>1;
             }
             res.add(new ArrayList<>(list));
        }
        System.out.println(res);
        System.out.println("结果数为:" + (nbit - 1));
    }

    public static void combination2(String s,int len){
        char[] chars = s.toCharArray();
        combination2(chars,0,len,new ArrayList());

    }
    public static void combination2(char [] array, int start, int len, List list){
        if (len == 0){
            System.out.println(list);
            return;
        }

        for (int i = start;i<array.length;i++){
            list.add(array[i]);
            combination2(array,i+1,len-1,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
//        new Solution11().combination("cgz");
        String string = "ab";
//        for (int i = 0;i<=string.length();i++){
//            combination2(string,i);
//        }
        combinationV2(string);




    }
}
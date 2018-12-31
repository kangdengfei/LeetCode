package mysolution;

import java.util.Queue;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-11-02 16:31
 **/

 //((3+5)*6)/(s36)
public class MySolution1 {

    public int sum(int n, int m){
        return n+m;
    }
    public int del(int n, int m){
        return n-m;
    }

    public int ch(int n, int m){
        return n*m;
    }
    public int cu(int n,int m){
        return n/m;
    }

    public static String minWindow(String S, String T) {
        int[] srcHash = new int[255];
        int count = T.length();
        int start = 0;
        int end = 0;
        String target = null;
        int min = Integer.MAX_VALUE;
        // 记录目标字符串每个字母出现次数
        for (int i = 0; i < T.length(); i++) {
            srcHash[T.charAt(i)]++;
        }

        for (int i=0;i< S.length();i++){
            if(srcHash[S.charAt(i)]-- >0)
                count--;
            // T 中的字符串都出现在窗口中，将左端右移
            if (count ==0){
                end = i;
                while (count == 0){
                   if (srcHash[S.charAt(start++)]++ ==0){
                       count++;
                   }
                }
                int len = i-start+1;
                if (min > len){
                    min = len;
                    target = S.substring(start,end+1);
                }
            }

        }


        return target;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }



}




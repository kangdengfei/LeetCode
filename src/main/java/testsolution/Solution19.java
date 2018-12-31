package testsolution;

import java.util.HashSet;
import java.util.Set;

/**
 * created  by KDF on 2017/11/15.
 * 在一个字符串中找到第一个只出现一次的字符
 */


public class Solution19 {
    public static void findtaSingle(char[]arry){
        if(arry.length<0)
            System.out.println("无满足条件");
        int [] hashtable=new int[26];
        for (int i =0;i<arry.length;i++){
            hashtable[arry[i]-'a']++;
        }
        for(int i=0;i<arry.length;i++){
            if(hashtable[arry[i]-'a']==1){
                System.out.println(arry[i]);
                break;
            }
        }
    }

    public static void findtaSingle2(char []array){
        if(array.length<0)
            System.out.println("无法满足条件");
        Set<Character> set = new HashSet<Character>();
        set.add(array[0]);
        for (int i = 1; i < array.length; i++){
            if (set.contains(array[i])){
            }else {
                System.out.println(array[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        char []array= {'a','a','v','s','d'};
        findtaSingle(array);
        findtaSingle2(array);
    }
}

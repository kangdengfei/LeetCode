package LintCode100;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 10:24
 **/
public class Longest_Substring_Without_Repeating_Characters_3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        char[] array = s.toCharArray();
        Set set = new HashSet();
        int max =   0;
        for(int i = 0;i<array.length;i++){
            for(int j =i; j<array.length;j++){
                if(!set.contains(array[j])){
                    set.add(array[j]);
                    max = Math.max(max,set.size());
                }else{
                    set.clear();
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String string = " ";
        System.out.println(lengthOfLongestSubstring(string));


    }
}




package mysolution;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-05 13:59
 *
 * 给定一个字符串str，返回str的最长无重复字符串长度
 **/

public class MySolution2 {

    public static int maxUnique(String str){
        Set<Character> set =  new HashSet();
        int max = 0;
        for (int i= 0;i<str.length();i++){
            for (int j = i;j<str.length();j++){
                if (!set.contains(str.charAt(j))){
                    set.add(str.charAt(j));
                }else
                    break;
            }
            max = Math.max(max,set.size());
            set.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "aabcb";
        System.out.println(maxUnique(str));
        Set<Integer> set= new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }
}




package LeetCode1_100;


import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-31 18:52
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 **/

//map key为字符串，value 为list，保存相似的元素
public class Group_Anagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return null;
        }
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0;i<strs.length;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = new String(chars);

            if (map.containsKey(s1)){
                map.get(s1).add(s);
            }else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(s1,list);
            }

        }
        List<List<String>> lists = new ArrayList<List<String>>();
        Set<String> strings = map.keySet();
        for (String s : strings){
            lists.add(map.get(s));
        }

        return lists;
    }

    public static void main(String[] args) {
        String[] string = {"eat","tea","tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(string));
    }

}




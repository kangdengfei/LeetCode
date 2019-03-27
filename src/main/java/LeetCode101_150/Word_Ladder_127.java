package LeetCode101_150;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-25
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 *     Only one letter can be changed at a time.
 *     Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *
 *     Return 0 if there is no such transformation sequence.
 *     All words have the same length.
 *     All words contain only lowercase alphabetic characters.
 *     You may assume no duplicates in the word list.
 *     You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 **/
/*
其实如果从递归的角度来看，并非不可以实现。每一种普遍情况也就是将当前单词修改一个字符成为当前字典中的一个单词。但是这种要遍历所有的情况，哪怕是已经超过最小操作次数的情况，导致代码超时。其实从另一个角度来说，这道题可以看做是广度优先算法的一个展示。

按上文中的题目为例，可以将广度优先算法写成以下形式。

    hit
    /
  hot
  / \
dot  lot
/    /
dog  log
/     /
cog  cog
 */
public class Word_Ladder_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0){
            return 0;
        }
        LinkedList queue = new LinkedList();
        queue.offer(beginWord);
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size >0){
                String from = (String) queue.pop();
                if (from.equals(endWord)){
                    return step + 1;
                }
                for(Iterator<String> iterator = wordList.iterator(); iterator.hasNext();) {
                    String current = iterator.next();
                    if (cantranfer(current, from)) {
                        iterator.remove();
                        queue.offer(current);
                    }
                }
                size--;
            }
            step++;
        }
        return 0;
    }

    public static boolean cantranfer(String from,String to){
        for(int i = 0, count=0 ; i<to.length() ; i++){
            if(from.charAt(i)!=to.charAt(i) && ++count>1) return false;
        }
        return true;

    }

    public static void main(String[] args) {
       String beginWord = "hit";
       String endWord = "cog";
       List list = new ArrayList();
       list.add("hot");
       list.add("dot");
       list.add("lot");
       list.add("log");
       list.add("cog");
       System.out.println(ladderLength(beginWord,endWord,list));
    }
}




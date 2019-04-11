package LeetCode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 18:38
 *
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 递归 + 深度遍历  、
 * 不熟练吃大亏
 **/
public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        if(n <=0)
            return null;
        List<String> list = new ArrayList<String>();
        List<String> combList = new ArrayList<String>();
        generateParenthesis(list,combList,0,0,n);
        return list;
    }

    public void generateParenthesis(List<String> list,List<String> combList,int m ,int n,int k){
        if(combList.size() == 2 * k){
            StringBuilder str = new StringBuilder();{
                for(String s : combList){
                    str.append(s);
                }
                list.add(str.toString());
                return;

            }
        }

        if(m<k){
            combList.add("(");
            generateParenthesis(list,combList,m+1,n,k);
            combList.remove(combList.size()-1);
        }
        if(n<k && n<m){
            combList.add(")");
            generateParenthesis(list,combList,m,n+1,k);
            combList.remove(combList.size()-1);
        }

    }


    /*
    DFS
     */
    public static List<String> generateParenthesis2(int n) {
        if(n <=0)
            return null;
        List<String> list = new ArrayList<String>();
        DFS(list,"",0,0,n);
        return list;
    }
    public static void DFS(List<String> list,String temp,int m ,int n,int k){
        if (temp.length() == 2*k){
            list.add(temp);
        }
        if (m<k){
            DFS(list,temp+"(",m+1,n,k);
        }
        if (m>n && n<k){
            DFS(list,temp+")",m,n+1,k);

        }

    }


    @Deprecated
    public static List<String> generateParenthesis3(int n) {
        if(n <=0)
            return null;
        List<String> list = new ArrayList<String>();
        DFS2(list,new StringBuilder(),0,0,n);
        return list;
    }
    public static void DFS2(List<String> list,StringBuilder temp,int m ,int n,int k){
        if (n == k && m == k){
            list.add(temp.toString());
        }
        if (m<k){
            DFS2(list,temp.append("("),m+1,n,k);
        }
        if (m>n && n<k){
            DFS2(list,temp.append(")"),m,n+1,k);

        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis2(3));
        System.out.println(generateParenthesis3(3));
    }

    }




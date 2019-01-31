package LintCode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 16:25
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 **/
public class Letter_Combinations_of_a_Phone_Number_17 {
   static String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public  static List<String> letterCombinations(String digits) {
        if(digits == null){
            return null;
        }
        List<String> list = new ArrayList<String>();
        List<String> comnList = new ArrayList<String>();
        letterCombinations(list,comnList,0,digits);
        return list;
    }

    public static void letterCombinations(List<String> list, List<String> comnList,int index,String digits){
        if(index== digits.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : comnList){
                stringBuilder.append(s);
            }
            list.add(stringBuilder.toString());
            return;
        }
        String substring = digits.substring(index,index+1);
        Integer integer = Integer.valueOf(substring);
        String str = strs[integer] ;
        for (int i = 0;i<str.length();i++) {
            comnList.add(str.substring(i,i+1));
            letterCombinations(list, comnList, index + 1, digits);
            comnList.remove(comnList.size() - 1);
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}




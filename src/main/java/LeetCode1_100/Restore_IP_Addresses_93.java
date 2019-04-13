package LeetCode1_100;

import com.sun.javafx.scene.layout.region.LayeredBackgroundSizeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 16:00
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 **/
/*
两种方法
DFS
暴力
 */
public class Restore_IP_Addresses_93 {
    static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length()<4)
            return res;
        DFS(new ArrayList<>(),0,s);
        return res;
    }
    public static void DFS(List<String> list,Integer start,String s ){
        if (list.size() == 4 || start == s.length() ){
            if (list.size() == 4 && start == s.length()){
                storeId(list);
            }else
                return;

        }

        for (int i =start ;i<start+3 && i<s.length();i++){
            String substring = s.substring(start, i + 1);
            if (Integer.parseInt(substring) <= 255){
                list.add(substring);
                DFS(list,i+1,s);
                list.remove(list.size()-1);
            }
            if (substring.charAt(0) == '0'){
                break;
            }
        }
    }

    public static void storeId(List<String> list){
        String temp = "";
        for (String s : list){
            temp =temp+s+".";
        }
        res.add(temp.substring(0,temp.length()-1));
    }

    public static List<String> restoreIpAddressesV2(String s) {
        if (s.length()<4 || s.length() >12 || s == null){
            return null;
        }
        for (int i=0;i<3;i++){
            for (int j = i+1;j<i+4 && j<s.length();j++){
                for (int k = j+1; k< j+4 && k<s.length()-1;k++){
                    String s1 = s.substring(0,i+1);
                    String s2 = s.substring(i+1,j+1);
                    String s3 = s.substring(j+1,k+1);
                    String s4 = s.substring(k+1);
                    if (check(s1) && check(s2) && check(s3) && check(s4)){
                        String temp = s1+"."+s2+"."+s3+"."+s4;
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }

    public static boolean check(String string){
        if (string.charAt(0) == '0'){
            return string.length() == 1 ? true:false;
        }else {
            if (Integer.parseInt(string)<=255)
                return true;
            else
                return false;
        }

    }


        public static void main(String[] args) {
        String stren = "1111";
        System.out.println(restoreIpAddressesV2(stren));
    }
}




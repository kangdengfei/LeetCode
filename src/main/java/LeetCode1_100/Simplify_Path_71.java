package LeetCode1_100;

import java.util.Stack;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-01 13:56
 **/

//使用栈
public class Simplify_Path_71 {
    public static String simplifyPath(String path) {
        if(path == null){
            return null;
        }
        Stack stack = new Stack();
        for(int i = 0;i<path.length();i++){
            //先判断是否超过长度
            while (i<path.length() && path.charAt(i) == '/'){
                i++;
            }
            String string = "";
            while (i < path.length() && path.charAt(i) != '/' ){
                string = string+path.charAt(i++);
            }
            if (string.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            //一开始用== 比较是错的， 字符串比较是否相等用equals
            if (!string.equals( "..") && !string.equals(".") && !string.equals("")){
                stack.push(string);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        String s ="";
        while (!stack.isEmpty()){
            s = "/"+stack.pop()+s;
        }
        return s;
    }

    public static void main(String[] args) {
        String string = "/home/"
                ;
        System.out.println(simplifyPath(string));
    }
}




package LeetCode1_100;

import java.util.Stack;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-01 13:56
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 *
 *
 * Example 1:
 *
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 *
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 *
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 * Example 4:
 *
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 *
 * Example 5:
 *
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 *
 * Example 6:
 *
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
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




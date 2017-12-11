import java.util.Scanner;

/**
 * created  by KDF on 2017/12/11.
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转的功能。
 * 比如输入字符串”abcdefg"和数字2,该函数将返回左旋转2位得到的结果“cdefgab"
 */


public class Solution25 {
       public static String resever(String str ){
           char []ch = str.toCharArray();
           for(int i = 0;i<ch.length/2;i++){
               char temp = ch[i];
               ch[i] = ch[ch.length-i-1];
               ch[ch.length-i-1] = temp;
           }
           return String.valueOf(ch);
       }
       public static void reseverString (String str ,int index ){
           String s1 = str.substring(0,index);
           String s2 = str.substring(index,str.length());
           StringBuilder sb = new StringBuilder();
           sb.append(resever(s1));
           sb.append(resever(s2));

           System.out.println(resever(sb.toString()));

       }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = sc.nextInt();
        reseverString(str,index);
    }

}

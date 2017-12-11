import java.util.Scanner;

/**
 * created  by KDF on 2017/12/1.
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串为“I am a Student.",则输出为”Student. a am i".
 */


public class Solution23 {
    public static String reverse(String str){
        char[]ch = str.toCharArray();
        for(int i =0;i<ch.length/2;i++){
            char temp = ch[i];
            ch[i] = ch[ch.length-i-1];
            ch[ch.length-i-1] = temp;
        }
       return String.valueOf(ch);
    }

    public static String reverseSentence(String str){
        if(str == null)
            return null ;
        String sentenceReverse = reverse(str);
        String []st = sentenceReverse.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<st.length;i++){

            sb.append(reverse(st[i]));
            if(i != st.length-1)
                sb.append(" ");

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st  = scanner.nextLine();
        String a =reverseSentence(st);
        System.out.println(a);
    }
}

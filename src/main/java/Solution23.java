import java.util.Scanner;

/**
 * created  by KDF on 2017/12/1.
 */


public class Solution23 {
    public static String ReverseSentence(String str){
        System.out.println(str);
        String[] a = str.split(str);
        for(int i= 0;i<a.length;i++) {
            System.out.println(a[i]);
        }
        String temp =null;
        for(int i =0;i<a.length/2;i++){
            temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
        for(int i= 0;i<a.length;i++) {
            System.out.println(a[i]);
        }
        return a.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st  = scanner.nextLine();
        String a =ReverseSentence(st);
        System.out.println(a);


    }
}

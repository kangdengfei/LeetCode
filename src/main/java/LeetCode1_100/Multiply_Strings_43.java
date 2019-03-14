package LeetCode1_100;


import javax.sound.midi.Soundbank;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-14 11:33
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 *
 *     The length of both num1 and num2 is < 110.
 *     Both num1 and num2 contain only digits 0-9.
 *     Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *     You must not use any built-in BigInteger library or convert the inputs to integer directly.
 **/
public class Multiply_Strings_43 {
    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int count = n + m;
        int []array = new int [count];
        for (int i = 0;i < m;i++){ //被乘数
            int index = count;
            for (int j = 0;j < n;j++){ //乘数
                int temp1 = Integer.valueOf(num2.charAt(m-i-1)-48);
                int temp2 = Integer.valueOf(num1.charAt(n-j-1)-48);
                int num = temp1 * temp2;
                array[index-1] += num % 10;
                if (array[index-1] > 9){
                    array[index-1] = array[index-1] - 10;
                    array[index-2] += 1;
                }
                array[index-2] += num / 10;
                if (array[index-2] > 9){
                    array[index-2] = array[index-2] - 10;
                    array[index-3] += 1;
                }
                index--;
            }
            count--;
        }

        int k = 0;
        for ( k=0;k<array.length;k++){
            if (array[k]!= 0)
                break;
        }
        if (k == array.length)
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = k;i<array.length;i++){
            stringBuilder.append(array[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String n = "0";
        String m ="0";
        System.out.println(multiply(n,m));
        char c1 = '2';
        String c2 = "2";
        System.out.println(Integer.valueOf(c1));
        System.out.println(Integer.valueOf(c2));
    }

}




import java.util.Queue;
import java.util.Scanner;


/**
 * created  by KDF on 2017/9/28.
 */


public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            double result = 0;
            double num = n;
            for (int i = 0;i<m;i++){
                result+=num;
                num= Math.sqrt(num);
            }
            System.out.println("n="+n);
            System.out.println("m="+m);
            System.out.println(result);

        }
    }
}

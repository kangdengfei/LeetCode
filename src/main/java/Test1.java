import java.util.Queue;
import java.util.Scanner;


/**
 * created  by KDF on 2017/9/28.
 */


public class Test1 {
    public static void main(String[] args) {
        System.out.println(test());
    }
        static int test()
        {
            int x = 1;
            try
            {
                x++;
                return x;
            }
            finally
            {
                ++x;

            }

        }

}

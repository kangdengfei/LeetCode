package testsolution;

import java.util.Arrays;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-25 13:05
 **/
public class Test2 {

    public static void main(String[] args) {
        String string= " a b";
        System.out.println(string);
        String trim = string.trim();

        System.out.println(trim);
        String[] split = trim.split(" ");
        System.out.println(Arrays.toString(split));
    }
}




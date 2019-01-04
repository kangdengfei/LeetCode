package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-10 18:59
 **/
public class Test_1 {
    public static String getString(int mun){
        char [] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
        'u','v','w','x','y','z'};
        StringBuilder stringBuilder = new StringBuilder();
        while (mun!=0){
            int i = (mun -1)%26;
            mun = (mun-i)/26;
            stringBuilder.append(array[i]);
        }

        return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(getString(54).toUpperCase());
    }
}




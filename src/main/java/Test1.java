


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
            catch (Exception e){
                x++;
                return x;
            }
            finally
            {
                ++x;
//                return x;

            }

        }

}

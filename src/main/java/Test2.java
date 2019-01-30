import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-25 13:06
 **/
public class Test2 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(combion(n).size());
    }

    public static List<List<String>> combion(int k) {
        if (k <= 0)
            return null;
        List<List<String>> list = new ArrayList();
        List combList = new ArrayList();
        int m = 0;//"("
        int n = 0;//")"
        combion(k, list, combList, m, n);
        return list;
    }

    public static void combion(int k, List<List<String>> list, List<String> combList, int m, int n) {
        if (combList.size() == 2 * k) {
            list.add(new ArrayList(combList));
            return;
        }
        if (m < k) {
            combList.add("(");
            combion(k, list, combList, m + 1, n);
            combList.remove(combList.size() - 1);
        }
        if (n < k && n < m) {
            combList.add(")");
            combion(k, list, combList, m, n + 1);
            combList.remove(combList.size() - 1);
        }
    }

}




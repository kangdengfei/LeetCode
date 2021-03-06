import java.util.ArrayList;
import java.util.List;

/**
 * created  by KDF on 2017/9/28.
 * 输入一个n ，打印所有可能的括号组合
 */


public class Test1 {
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


//
    static ArrayList<String> list = new ArrayList();
//    public static void main(String[] args) {
//        int n =2;
//        dfs(0,0,"",n);
//        for (int i = 0; i < list.size(); i++)
//            System.out.print(list.get(i) + (i != list.size() - 1 ? "," : "\n"));
//
//    }

    static void dfs(int l, int r, String str, int n){
        if(str.length()==n*2){
            list.add(str);
            return;
        }
        if(l<n)
            dfs(l+1, r, str+'(', n);
        if(r<n&&l>r)
            dfs( l, r+1, str+')', n);
    }

}

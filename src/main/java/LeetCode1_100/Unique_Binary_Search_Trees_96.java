package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-29 18:39
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 递归调用
 */
public class Unique_Binary_Search_Trees_96 {

    public int numTrees(int n) {
        if (n == 0 ||n == 1){
            return 1;
        }
        int num = 0;
        for(int i = 1;i<=n;i++){
            num += numTrees(i-1)*numTrees(n-i);
        }
        return num;
    }

    /*
    加缓存减少消耗时间，避免重复计算，空间换时间
     */
    public static int numTrees2(int n) {
        if (n == 0 ||n == 1){
            return 1;
        }
        int num = 0;
        int temp1;
        int temp2;
        Map map = new HashMap<>();
        for(int i = 1;i<=n;i++){

            if (map.containsKey(i-1)){
                temp1 = (int) map.get(i-1);
            }else{
                temp1 = numTrees2(i-1);
                map.put(i-1,temp1);
            }

            if (map.containsKey(n-i)){
                temp2 = (int) map.get(n-i);
            }else{
                temp2 = numTrees2(n-i);
                map.put(n-i,temp2);
            }
            num += temp1 * temp2;

        }
        return num;
    }

    static Map map = new HashMap<>();
    public static int numTrees3(int n) {
        if (n == 0 ||n == 1){
            return 1;
        }
        int num = 0;
        if (map.containsKey(n-1)){
            return (int) map.get(n-1);
        }
        for(int i = 1;i<=n;i++){
            num += numTrees3(i-1)*numTrees3(n-i);
            map.put(i,num);

        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(numTrees3(3));
    }
}




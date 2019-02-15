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
}




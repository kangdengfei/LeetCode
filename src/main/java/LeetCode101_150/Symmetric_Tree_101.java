package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 18:51
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 **/

//开始想法通过中序遍历看是否对称的想法是错的，
//通过递归进行求解
public class Symmetric_Tree_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }else{
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

        }
    }
}




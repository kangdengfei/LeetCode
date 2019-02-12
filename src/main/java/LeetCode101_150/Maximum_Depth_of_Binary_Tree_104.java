package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-12 10:02
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 **/
public class Maximum_Depth_of_Binary_Tree_104 {
    public int maxDepth(TreeNode root) {
        return find(root);
    }
    public int find(TreeNode root){
        if(root == null)
            return 0;
        int left = find (root.left);
        int right = find(root.right);
        return left > right ? left+1 : right+1;
    }
}




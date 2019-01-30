package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-29 18:22
 * 111. Minimum Depth of Binary Tree
 * Easy
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 * 求最小深度
 **/
public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {
        return find(root);
    }
    public int find(TreeNode root){
        if (root == null)
            return 0;
        if(root.left == null){
            return find(root.right)+1;
        }
        if (root.right == null){
            return find(root.left)+1;
        }
        int left = find(root.left);
        int right = find(root.right);
        return left > right ? right+1 : left+1;


    }
}




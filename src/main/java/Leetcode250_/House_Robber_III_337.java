package Leetcode250_;



/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-04
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 **/

/*
动态规划
两种选择，打劫跟节点跟孙节点，打劫子节点。两种情况的最大值。
 */

public class House_Robber_III_337 {
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }

        int result1 = root.val + (root.left == null? 0: (rob(root.left.left)+rob(root.left.right)))+(root.right ==null ? 0 :(rob(root.right.left)+rob(root.right.right)));
        int result2 = rob(root.left)+rob(root.right);
        return Math.max(result1,result2);

    }


    /*

    如果小偷偷了当前结点，那么它的子结点不能偷
    如果小偷不偷当前结点，那么子结点可以偷，也可以不偷（取其中较大的即可）
     */
    public int robV2(TreeNode root){
        int[] max = max(root);
        return Math.max(max[0],max[1]);

    }

    public int [] max(TreeNode node){
        int [] res = new int[2];
        if (node == null){
            return res;
        }
        int [] left = max(node.left);
        int [] right = max(node.right);
        res[0] = node.val + left[1]+right[1];//取当前元素
        res[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//不取当前节点
        return res;

    }
}

/*
两次遍历二叉树，会产生重复计算
解决方法:1.加缓存
 */


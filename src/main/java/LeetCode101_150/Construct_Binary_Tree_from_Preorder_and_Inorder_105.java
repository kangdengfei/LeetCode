package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-26 09:27
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 **/

/**
 * 题解：
 *
 *
 *
 *      1
 *     / \
 *    2   3
 *   / \ / \
 *  4  5 6  7
 *
 * 对于上图的树来说，
 *         index: 0 1 2 3 4 5 6
 *      先序遍历为: 1 2 4 5 3 6 7
 *      中序遍历为: 4 2 5 1 6 3 7。
 * 可以发现的规律是：
 * 1. 先序遍历的从左数第一个为整棵树的根节点。
 * 2. 中序遍历中根节点是左子树右子树的分割点。
 *
 * 再看这个树的左子树：
 *      先序遍历为: 2 4 5
 *      中序遍历为: 4 2 5
 * 依然可以套用上面发现的规律。
 *
 * 右子树：
 *      先序遍历为: 3 6 7
 *      中序遍历为: 6 3 7
 * 也是可以套用上面的规律的。
 *
 * 所以这道题可以用递归的方法解决。
 * 具体解决方法是：
 * 通过先序遍历找到第一个点作为根节点，在中序遍历中找到根节点并记录index。
 * 因为中序遍历中根节点左边为左子树，所以可以记录左子树的长度并在先序遍历中依据这个长度找到左子树的区间，用同样方法可以找到右子树的区间。
 * 递归的建立好左子树和右子树就好
 */
/*
前序跟中序构建二叉树
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length || preorder == null || inorder == null){
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    public static TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if (instart > inend || prestart > preend){
            return null;
        }
        int rootVal = preorder[prestart];
        int rootIndex = 0;
        for(int i = instart;i<=inend;i++){
            if(rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex-instart;

        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(preorder,prestart+1,prestart+len,inorder,instart,rootIndex-1);
        node.right = buildTree(preorder,prestart+len+1,preend,inorder,rootIndex+1,inend);
        return node;
    }

    public static void main(String[] args) {
        int [] inorder = {3,9,20,15,7};
        int [] preordr = {9,3,15,20,7};
        System.out.println(buildTree(inorder,preordr));

     }

}




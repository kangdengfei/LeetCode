package LeetCode101_150;


/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
/*
中序后序构建二叉树
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder == null ||postorder == null){
            return null;
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public static TreeNode buildTree(int[] inorder,int start,int end, int[] postorder,int left,int right) {
        if(start > end || left > right){
            return null;
        }
        int treeNodeVal = postorder[right];
        int index = 0;
        for(int i = start;i<=end;i++){ //这里有等号，注意下标的起始位置
            if(inorder[i] == treeNodeVal){
                index = i;
                break;
            }
        }

        int len = index - start;
        TreeNode node = new TreeNode(treeNodeVal);

        node.left = buildTree(inorder,start,index-1,postorder,left,left+len-1);
        node.right = buildTree(inorder,index+1,end,postorder,left+len,right-1);
        return node;
    }


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        System.out.println(buildTree(inorder,postOrder));
    }
}

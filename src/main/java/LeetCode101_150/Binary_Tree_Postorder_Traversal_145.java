package LeetCode101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-12 16:22
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 **/
public class Binary_Tree_Postorder_Traversal_145 {

    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;

    }

    public void postorder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postorder(treeNode.left);
        postorder(treeNode.right);
        list.add(treeNode.val);
    }

}




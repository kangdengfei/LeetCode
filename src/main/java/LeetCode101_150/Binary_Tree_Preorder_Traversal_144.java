package LeetCode101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-12 16:46
 **/
public class Binary_Tree_Preorder_Traversal_144 {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }
    public void preorder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        preorder(treeNode.left);
        preorder(treeNode.right);
        list.add(treeNode.val);
    }
}




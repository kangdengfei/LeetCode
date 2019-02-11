package LintCode100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 16:18
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 **/
//两种方法，递归和非递归
public class Binary_Tree_Inorder_Traversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            while (root.left!= null){
                stack.push(root.left);
                root = root.left;
            }
            if (!stack.isEmpty()){
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if (pop.right!=null){
                    root = pop.right;
                }
            }
        }
        return list;

    }
}




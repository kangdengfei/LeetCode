package LeetCode101_150;



import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 18:27
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 **/
public class Binary_Tree_Level_Order_Traversal_102 {
    public List<List<Integer>> levelOrderV2(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null)
            return list;
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        boolean flag = true;

        list1.offer(root);
        while(!list1.isEmpty() || !list2.isEmpty()){
            List<Integer> tempList= new ArrayList<Integer>();
            if(flag){
                while(!list1.isEmpty() ){
                    TreeNode node = list1.pop();
                    tempList.add(node.val);
                    if(node.left != null){
                        list2.offer(node.left);
                    }
                    if(node.right != null){
                        list2.offer(node.right);
                    }


                }
            }else{
                while(!list2.isEmpty() ){
                    TreeNode node = list2.pop();
                    tempList.add(node.val);
                    if(node.left != null){
                        list1.offer(node.left);
                    }
                    if(node.right != null){
                        list1.offer(node.right);
                    }
                }
            }
            list.offer(tempList);
            flag = !flag;

        }
        return list;
    }

    /**
     * 广度遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            TreeNode node = null;
            while (size > 0){
             node = queue.pop();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                list.add(node.val);
                size--; //少了这个在执行pop()操作时会抛NoSuchElementException
            }
            lists.add(list);
        }
        return lists;

    }

}




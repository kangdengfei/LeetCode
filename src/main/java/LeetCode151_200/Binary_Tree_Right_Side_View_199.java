package LeetCode151_200;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-28 11:53
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 **/
public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list= new ArrayList<Integer>();
        if(root == null)
            return list;
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        boolean flag = true;
        boolean flag2 = true;
        list1.offer(root);
        while(!list1.isEmpty() || !list2.isEmpty()){
            if(flag){
                TreeNode node = list1.poll();
                if(flag2){
                    list.add(node.val);
                    flag2= false;
                }
                if(node.right != null)
                    list2.offer(node.right);
                if(node.left!=null)
                    list2.offer(node.left);
                if(list1.isEmpty()){
                    flag=false;
                    flag2= true;
                }
            }else{
                TreeNode node = list2.poll();
                if(flag2){
                    list.add(node.val);
                    flag2=false;
                }
                if(node.right!=null)
                    list1.offer(node.right);
                if(node.left!=null)
                    list1.offer(node.left);
                if(list2.isEmpty()){
                    flag=true;
                    flag2=true;
                }
            }
        }

        return list;
    }
}




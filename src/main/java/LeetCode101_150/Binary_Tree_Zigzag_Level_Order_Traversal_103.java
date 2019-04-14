package LeetCode101_150;

import java.util.*;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-12 09:26
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 **/
//两个栈做
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return null;
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();//奇数层先左后右
        Stack<TreeNode> stack2 = new Stack<TreeNode>();//偶数层先右后左
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        boolean falg = true;

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            if (falg){
                while (!stack1.isEmpty()){
                    TreeNode pop = stack1.pop();
                    list.add(pop.val);
                    if (pop.left != null){
                        stack2.push(pop.left);
                    }
                    if (pop.right != null){
                        stack2.push(pop.right);
                    }
                }
                falg=false;
                lists.add(new ArrayList<Integer>(list));

            }else {
                while (!stack2.isEmpty()){
                    TreeNode pop = stack2.pop();
                    list.add(pop.val);
                    if (pop.right != null){
                        stack1.push(pop.right);
                    }
                    if (pop.left != null){
                        stack1.push(pop.left);
                    }
                }
                falg=true;
                lists.add(new ArrayList<Integer>(list));
            }
        }


        return lists;

    }

    public static void main(String[] args) {
        int head = 0;
        int []elements = new int[16];
        head = (head - 1) & (elements.length - 1);

        System.out.println(head);
        head = (head - 1) & (elements.length - 1);
        System.out.println(head);
        String string = "1234";
        List list = new ArrayList();

    }
}




package LeetCode101_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-12 11:39
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 **/
public class Path_Sum_112 {
    static boolean flag = false;
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        combin(root,sum,new ArrayList());
        return flag;
    }

    public static void combin(TreeNode root, int sum,List list){
        list.add(root.val);
        if (root.left == null && root.right == null){
            int target = 0;
            for (int i = 0;i<list.size();i++){
                Integer integer= (Integer)list.get(i);
                target+= integer.intValue();
            }
            if (target == sum){
                flag = true;
            }
        }
        if (root.left != null){
            combin(root.left,sum,list);
        }
        if (root.right != null){
            combin(root.right,sum,list);
        }
        list.remove(list.size()-1);
    }


    public static void combinV2(TreeNode root, int sum,List list){
        if (root.left == null && root.right == null){
            int target = 0;
            for (int i = 0;i<list.size();i++){
                Integer integer= (Integer)list.get(i);
                target+= integer.intValue();
            }
            if (target == sum){
                flag = true;
            }
        }

        if (root.left != null){
            list.add(root.left.val);
            combinV2(root.left,sum,list);
            list.remove(list.size()-1);
        }
        if (root.right != null){
            list.add(root.right.val);
            combinV2(root.right,sum,list);
            list.remove(list.size()-1);
        }
    }
    public static TreeNode createBinTree() {
        int [] array = {1,2,3,4,5,6};
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);

        TreeNode tl =  treeNode.left;
        TreeNode tr = treeNode.right;
        tl.left = new TreeNode(11);
        tr.left = new TreeNode(13);
        tr.right = new TreeNode(4);

        TreeNode tll = tl.left;
        tll.left = new TreeNode(7);
        tll.right = new TreeNode(2);

        TreeNode trr = tr.right;
        trr.left = new TreeNode(5);
        trr.right = new TreeNode(1);
        return treeNode;
    }

    public static void main(String[] args) {
        System.out.println(hasPathSum(createBinTree(),22));
    }
}




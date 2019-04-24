package LeetCode101_150;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-10 15:57
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 *  /  \    / \
 * 7    2  5   1
 *
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 **/
public class Path_Sum_II_113 {


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return null;
        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
        List<Integer> list =  new ArrayList();
        return caculateValue(root,list,sum,sumList);
    }


    public static List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if(root == null)
            return null;
        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
        List<Integer> list =  new ArrayList();
        DFS(root,list,sum,sumList);
        return sumList;
    }
    public static void DFS(TreeNode root, List list, int sum, List sumList){

        if (root == null )//递归终止条件|| sum < root.val 这个条件得去掉，sum是负数时不成立
            return;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
            sumList.add(new ArrayList(list));
//            return;  这不是递归终止的条件
        }
        DFS(root.left,list,sum-root.val,sumList);
        DFS(root.right,list,sum-root.val,sumList);
        list.remove(list.size()-1);
    }

    public static List<List<Integer>>  caculateValue(TreeNode root, List list, int sum, List sumList){
        //先要将数据加入
        list.add(root.val);
        if(root.left == null && root.right == null){
            int s = 0;
            for(int i = 0;i<list.size();i++){
                Integer o = (Integer)list.get(i);
                s += o;
            }
            if(s == sum)
                sumList.add(new ArrayList(list));
        }

        if(root.left != null){
            caculateValue(root.left,list,sum,sumList);
        }
        if(root.right != null){
            caculateValue(root.right,list,sum,sumList);
        }
        list.remove(list.size()-1);//回溯很重要的做法回退
      return sumList;
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
        System.out.println(pathSum2(createBinTree(),22) );
    }

}




package LeetCode101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-13 14:55
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 **/
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        List<Integer> list = new ArrayList<Integer>();
        getPath(root,list);
        return sum;
    }


    public void getPath(TreeNode root,List<Integer> list){
        list.add(root.val);
        if(root.left == null && root.right == null){
            int len = list.size();
            int m = 1;
            for(int i = len -1;i>=0;i--){
                sum += list.get(i)*m;
                m = m * 10;
            }
        }
        if(root.left != null){
            getPath(root.left,list);
        }
        if(root.right != null){
            getPath(root.right,list);
        }
        list.remove(list.size()-1);
    }
}



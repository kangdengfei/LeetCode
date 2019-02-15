package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 10:01
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 **/
public class Remove_Duplicates_from_Sorted_List_II_82 {
    //重新生成新的链表，并没有改变原链表
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode newhead = new ListNode(-1);
        ListNode node = new ListNode(-2);
        ListNode newPre = newhead;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur!= null){
            if (cur.val == pre.val){
                node = pre;
                cur = cur.next;
            }else {
                if(node.val == pre.val){
                    pre = cur;
                    cur = cur.next;
                }else {
                    newPre.next = new ListNode(pre.val);//这个步骤很重要，重新生成新的节点
                    newPre = newPre.next;
                    pre = cur;
                    cur = cur.next;
                }
            }

        }
        if (pre.val != node.val){
            newPre.next = pre;
        }
        return newhead.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        ListNode node = deleteDuplicates(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}




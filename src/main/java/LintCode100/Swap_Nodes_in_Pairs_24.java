package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 18:59
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *
 **/

//有点取巧，交换节点的值，并没有交换节点

public class Swap_Nodes_in_Pairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        if(node == null){
            return head;
        }
        ListNode p1 = head.next;
        while(head != null && p1 != null){
            int temp = node.val;
            node.val = p1.val;
            p1.val = temp;
            node = p1.next;
            if (node == null)
                return head;
            p1 = node.next;
        }
        return head;
    }
}




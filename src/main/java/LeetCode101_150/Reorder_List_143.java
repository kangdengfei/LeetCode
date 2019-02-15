package LeetCode101_150;


/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-12 17:38
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 **/

public class Reorder_List_143 {

    public void reorderList(ListNode head) {
        ListNode last = head.next;
        ListNode prelast = head;
        ListNode cur = head;
        while (last.next != null){
            last = last.next;
            prelast = prelast.next;
        }
        while (last != cur){
            ListNode next = cur.next;

        }

    }
}




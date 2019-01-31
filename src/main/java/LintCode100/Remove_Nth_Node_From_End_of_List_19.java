package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 17:14
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 **/
public class Remove_Nth_Node_From_End_of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode end = head;
        while(n>0 && end.next!= null){
            end = end.next;
            n--;
        }
        if(end.next == null && n>0){
            return head.next;
        }
        while(end.next != null){
            end = end.next;
            cur = cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}




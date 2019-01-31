package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-30 18:26
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 **/
public class Merge_Two_Sorted_Lists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newhead = new ListNode(-1);
        ListNode cur = newhead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while(l1 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return newhead.next;
    }
}




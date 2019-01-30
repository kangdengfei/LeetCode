package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-18 18:33
 * 83. Remove Duplicates from Sorted List
 * Easy
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 **/
public class Remove_Duplicates_from_Sorted_List_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode cur = head;
        ListNode  per = head;
        while(cur != null){

            if(per.val != cur.val){
                per.next = cur;
                per = per.next;
            }else
                cur = cur.next;
        }
        per.next = cur;
        return head;
    }
}




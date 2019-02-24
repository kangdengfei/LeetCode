package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 13:56
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 **/
public class Reverse_Linked_List_206 {
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }
}




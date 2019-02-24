package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 13:30
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 **/
/*
构建一个新的头单单作前置节点
 */
public class Remove_Linked_List_Elements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        ListNode cur = head;
        ListNode pre = newNode;

        while(cur!= null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }else{
                cur = cur.next;
                pre = pre.next;
            }

        }
        return newNode.next;
    }
}




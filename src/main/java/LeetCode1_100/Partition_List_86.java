package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-11 11:15
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 **/
public class Partition_List_86 {
    public static ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode temp = null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = newHead;
        //找到插入点
        while (cur != null){
            if (cur.val < x){
                cur = cur.next;
                pre = pre.next;
            }else {
              break;
            }
        }
        ListNode insertNode = pre;
        while (cur != null){
            if (cur.val < x){
                pre.next = cur.next;
                temp = insertNode.next;
                insertNode.next = cur;
                cur.next = temp;
                insertNode = insertNode.next;
                cur = pre.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] array = {1,4,3,2,5,2};
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        for (int i = 0;i<array.length;i++){
            ListNode node = new ListNode(array[i]);
            pre.next = node;
            pre = pre.next;
        }
        ListNode partition = partition(head.next, 3);
        while (partition != null){
            System.out.println(partition.val);
            partition = partition.next;
        }
    }
}




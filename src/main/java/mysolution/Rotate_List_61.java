package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-02 15:49
 **/
public class Rotate_List_61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head ==null)
            return null;
        int count = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            count++;
        }

        int i = k%count;
        if(i==0)
            return head;
        ListNode cur = head;
        ListNode end = head;
        while(i != 0){
            end = end.next;
            i--;
        }
        while(end != null){
            cur = cur.next;
            end = end.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        end.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 1;i<array.length;i++){
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        rotateRight(head,2);
    }
}




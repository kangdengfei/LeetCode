package LeetCode1_100;



/**
 * @program: Code
 * @author: KDF
 * @create: 2018-12-15 19:20
 **/
public class Reverse_Linked_List_II_92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m==0 || n==0 )
            return null;
        ListNode cur = head;
        ListNode prestart = null;
        ListNode end = null;
        int count = 1;

        while(cur != null ){
            if(m-1==count)
                prestart = cur;
            if(n==count)
                end = cur;
            count++;
            cur=cur.next;
        }
        if(count<n || m < 1 || m > n){
            return head;
        }
        ListNode ende = end.next;
        end.next = null;
        ListNode start = null;
        if (prestart == null){
            start = head;
        }else{
            start = prestart.next;
            prestart.next = null;
        }
        ListNode temp = start;
        ListNode newhead = null;
        ListNode pre = null;
        int t = n-m+1;
        while(t>0){
            pre = start.next;
            start.next = newhead;
            newhead = start;
            start = pre;
            t--;
        }
        temp.next = ende;
        if(prestart != null){
            prestart.next = newhead;
        }
        return prestart == null ? newhead : head;
    }


    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};

//        ListNode listNode = new ListNode(array[0]);
//        ListNode cur = listNode;
//        for (int i = 1; i<array.length;i++){
//            cur.next = new ListNode(array[i]);
//            cur = cur.next;
//        }
        ListNodeFactory listNodeFactory = new ListNodeFactory();
        for (int i = 0;i<array.length;i++){
            listNodeFactory.addLast(new ListNode(array[i]));
        }
        ListNode listNode = listNodeFactory.first.next;
        reverseBetween(listNode,2,4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}




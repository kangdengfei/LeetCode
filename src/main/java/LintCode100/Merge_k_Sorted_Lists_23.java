package LintCode100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-07 11:40
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 **/
public class Merge_k_Sorted_Lists_23 {
    public ListNode mergeKLists(ListNode[] lists) {

        //参数校验
        return mergeSort(lists,0,lists.length-1);
    }

    public ListNode mergeSort(ListNode[]lists, int start, int end){
        if(start == end){
            return lists[start];
        }else{
            int mid = start + (end-start)/2;
            ListNode left = mergeSort(lists,start,mid);
            ListNode right = mergeSort(lists,mid+1,end);
            return merge(left,right);
        }
    }



    public ListNode merge(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while(l1 != null && l2 != null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next  = l2;
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
        return newHead.next;
    }

}




import java.util.Scanner;
import java.util.Stack;

/**
 * created  by KDF on 2017/12/12.
 *
 *

 假定用一个链表表示两个数，其中每个节点仅包含一个数字。
 c假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
 样例

 给出 6->1->7 + 2->9->5。即，617 + 295。

 返回 9->1->2。即，912
 */


public class Solution28 {
    public static ListNode addLists2(ListNode l1,ListNode l2){
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();

        ListNode result = new ListNode(-1);
        ListNode r = result;

        int c = 0;

        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        while (s1.isEmpty()!=true && s2.isEmpty()!=true){
            int a = s1.pop();
            int b = s2.pop();
            int d = a+b;
            if(c == 1){
                d++;
                c = 0;
            }
            if(d>=10){
                d=d-10;
                c = 1;
            }
            s3.push(d);
        }
        while (s1.isEmpty()!=true){
            int a = s1.pop();
            if(c == 1){
                a++;
                c = 0;
            }
            if(a>9){
                a = a-10;
                c = 1;
            }
            s3.push(a);
        }
        while (s2.isEmpty()!=true){
            int b = s2.pop();
            if(c == 1){
                b++;
                c = 0;
            }
            if(b>9){
                b = b -10;
                c = 1;
            }
            s3.push(b);
        }
        if(c==1)
            s3.push(c);
        while (s3.isEmpty()!=true){
            r.next=new ListNode(s3.pop());
            r=r.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ListNode l1 = new ListNode(-1);
        ListNode p = l1;
        for(int i = 0;i<n;i++){
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        ListNode l2 = new ListNode(-1);
        ListNode q = l2;
        for(int j= 0;j<m;j++){
            q.next = new ListNode(scanner.nextInt());
            q = q.next;
        }
        ListNode result = addLists2(l1.next,l2.next);
        while (result!= null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
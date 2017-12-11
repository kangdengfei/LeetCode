import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created  by KDF on 2017/10/10.
 */


public class Solution4 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<Integer>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode= listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty())
        list.add(stack.pop());

        return list;
    }
}

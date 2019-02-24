package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 15:45
 **/
/*
删除一个节点
下一个节点的值赋值到把单前节点，删除下个节点
 */
public class Delete_Node_in_a_Linked_List_237 {
    public void deleteNode(ListNode node) {
        if(node== null || node.next == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}




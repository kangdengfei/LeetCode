package LeetCode1_100;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-03-13 14:54
 **/
public class ListNodeFactory {


    public ListNode first = new ListNode(-1);
    private ListNode last = first;
    public void addLast(ListNode node){
        if (last != null){
            last.next = node;
        }else
            first.next = node;
        last = node;
    }

    public void process(){
        first.next.say();
    }

    public static void main(String[] args) {
        ListNodeFactory listNodeFactory = new ListNodeFactory();
        int [] array =  {7,6,2,11,2,3,5,4};
        for (int i = 0;i<array.length;i++){
            listNodeFactory.addLast(new ListNode(array[i]));
        }

        listNodeFactory.process();
    }
}




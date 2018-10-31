import java.util.*;

/**
 * created  by KDF on 2017/11/15.
 */


public class BinTreeTraverse {
//    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] array = {7,5,9,4,6,8,10};
    private static List<Node> nodeList = null;
    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }


    /** 非递归实现中序遍历2 */
    public static void visit(Node p) {
        System.out.print(p.data + " ");
    }

    protected static void iterativeInorder2(Node p) {
        Stack<Node> stack = new Stack<Node>();
        Node node = p;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                visit(node);   //
                node = node.rightChild;
            }
        }
    }


    public static List mygd(Node root){
        List<Integer> list = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.leftChild!=null)
                queue.offer(root.leftChild);
            if (root.rightChild!= null)
                queue.offer(root.rightChild);
            list.add(root.data);
        }
        return list;
    }

    public static List mysd(Node root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack();
        Node node = root;
        while (node != null || !stack.empty()){
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            root =  stack.pop();
            list.add(root.data);
            root = root.rightChild;
        }
        return list;
    }
    public static void main(String[] args) {
        BinTreeTraverse binTree = new BinTreeTraverse();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

//        System.out.println("先序遍历：");
//        preOrderTraverse(root);
//        System.out.println();
//
//        System.out.println("中序遍历：");
//        inOrderTraverse(root);
//        System.out.println();
//
//        System.out.println("后序遍历：");
//        postOrderTraverse(root);
//        System.out.println();


        iterativeInorder2(root);
        System.out.println(mysd(root));
        System.out.println(mygd(root));
        Object o = new Object();
        o.hashCode();
    }

}

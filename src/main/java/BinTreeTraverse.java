import java.util.*;

/**
 * created  by KDF on 2017/11/15.
 */


public class BinTreeTraverse {
    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//    private int[] array = {7,5,9,4,6,8,10};
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


    /**
     * 层次遍历
     * @param root
     * @return
     */
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

    /**
     * 深度遍历
     * @param root
     * @return
     */
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

    /**
     * 求二叉树的最大高度
     * @param root
     * @return
     */
    public int depth(Node root){
        if (root == null){
            return 0;
        }
        int left = depth(root.leftChild);
        int right = depth(root.rightChild);
        return left>right?left+1:right+1;
    }


    /**
     * 是否为二叉搜素树
     * @return
     *
     * 无重复数据时： 中序遍历 数据依次递增
     */
    public boolean isBSF(){
        return true;
    }


    /**
     * 是否为二平衡二叉树
     * @param node
     * @return
     *
     * 先序遍历
     */
    public boolean isBlanceTree_1(Node node){
        return false;
    }


    /**
     * 是否为平衡二叉树
     * @param node
     * @return
     *
     *通过后序遍历，避免重复比较子树
     *比较左右子树高度是否相差为1
     *
     *
     */
    boolean flag = true;
    public boolean isBlanceTree_2(Node node){
        depth2(node);
        return flag;
    }


    public int depth2(Node node){
        if (node == null)
            return 0;

        int left = depth2(node.leftChild);
        int right = depth2(node.rightChild);

        if (Math.abs(left-right)>1){
            flag = false;
        }
        return left>right?left+1:right+1;
    }
    /**
     * 判断是否为完全二叉树
     * @param root
     * @return
     * 层次遍历
     * 1.有右节点无左节点 false；
     * 2.没有左节点或右节点，下面的都是叶子节点
     */
    public static boolean isCompleteTree(Node root){
            if (root== null){
                return true;
            }

        LinkedList<Node> linkedList = new LinkedList<Node>();
        linkedList.push(root);
        boolean flag = false;
        if(!linkedList.isEmpty()){
            Node node = linkedList.poll();
            Node left = root.leftChild;
            Node right = root.rightChild;
            if((flag&&((left!=null)||(right!= null))) || (left==null&&right!=null)){
                return false;
            }
            if (left!= null){
                linkedList.push(left);
            }
            if (right != null){
                linkedList.push(right);
            }else {
                flag = true; // 如果当前结点没有右孩子，那么之后层遍历到的结点必须为叶子结点
            }

        }
        return true;

    }

    public static List<Integer> rightSideView(Node root) {
        if(root == null)
            return null;
        Queue<Node>list1 = new LinkedList<Node>();

        Queue<Node> list2 = new LinkedList<Node>();
        List<Integer> list= new ArrayList<Integer>();
        boolean flag = true;
        boolean flag2 = true;
        list1.offer(root);
        while(!list1.isEmpty() || !list2.isEmpty()){
            if(flag){
                Node node = list1.poll();
                if(flag2){
                    list.add(node.data);
                    flag2= false;
                }
                if(node.rightChild != null)
                    list2.offer(node.rightChild);
                if(node.leftChild!=null)
                    list2.offer(node.leftChild);
                if(list1.isEmpty()){
                    flag=false;
                    flag2= true;
                }
            }else{
                Node node = list2.poll();
                if(flag2){
                    list.add(node.data);
                    flag2=false;
                }
                if(node.rightChild!=null)
                    list1.offer(node.rightChild);
                if(node.leftChild!=null)
                    list1.offer(node.leftChild);
                if(list2.isEmpty()){
                    flag=true;
                    flag2=true;
                }
            }
        }

        return list;
    }
    public static void main(String[] args) {
        BinTreeTraverse binTree = new BinTreeTraverse();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();
//
//        System.out.println("中序遍历：");
//        inOrderTraverse(root);
//        System.out.println();
//
//        System.out.println("后序遍历：");
//        postOrderTraverse(root);
//        System.out.println();


        iterativeInorder2(root);
//        System.out.println(mysd(root));
//        System.out.println(mygd(root));
//        System.out.println(isCompleteTree(root));
//
//        List<Integer> list = rightSideView(root);
//        System.out.println(list);
//
//        LinkedList linkedList = new LinkedList();
//        linkedList.offer(1);
//        linkedList.offer(2);
//        linkedList.offer(3);
//        System.out.println(linkedList.poll());
    }

}

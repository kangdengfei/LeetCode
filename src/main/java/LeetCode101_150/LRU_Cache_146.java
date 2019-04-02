package LeetCode101_150;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-02
 *
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 /* capacity */

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
        /*
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 **/

 /*
 双向链表+hashMap
 1.get时根据key到map 中查询，存在即返回val，并且把节点放到链表头，不存在返回-1；
 2.put时先判断值key是否存在，存在即更新，不存判断是否达到容量上限，超过即删除最后一个元素，同时删除hashMap的记录，插在链表头，没超过插在链表头
  */
public class LRU_Cache_146 {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;


     public LRU_Cache_146(int capacity) {
         this.capacity = capacity;
         map = new HashMap();
     }

     public int get(int key) {
         if (map.containsKey(key)){
             Node node = map.get(key);
             remove(node);
             setHead(node);
             return node.val;
         }
         return -1;
     }

     public void put(int key, int value) {

         if (map.containsKey(key)){
             Node node = map.get(key);
             node.val = value;
             map.put(key,node);
             remove(node);
             setHead(node);
         }else {
             Node node = new Node(key,value);
             if (map.size()>=capacity){
                 map.remove(tail.key);
                 remove(tail);
                 setHead(node);
             }else
                 setHead(node);
             map.put(key,node);
         }

     }

     private class Node{
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
     }

     public void remove(Node node){
         /*
         要不前节点跟后继节点都连上
          */
         if (node.pre != null){
             node.pre.next = node.next;
         }else
             head = node.next;
         if (node.next != null){
             node.next.pre = node.pre;
         }else
             tail = node.pre;

     }

     public void setHead(Node node){
         node.pre = null;
         node.next = head;
         if (head != null){
             head.pre = node;
         }
         head = node;
         if (tail == null){
             tail = head;
         }
     }


     public static void main(String[] args) {
         LRU_Cache_146 cache = new LRU_Cache_146(2);
         cache.put(1,1);
         cache.put(2,2);
         System.out.println( cache.get(1));
         cache.put(3,3);
         System.out.println( cache.get(2));
         cache.put(4,4);
         System.out.println(cache.get(1));
         System.out.println(cache.get(3));
         System.out.println(cache.get(4));


     }
}




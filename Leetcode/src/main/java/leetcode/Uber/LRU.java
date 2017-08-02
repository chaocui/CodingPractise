package leetcode.Uber;

import leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/6/14.
 */
public class LRU {

    /**
     * 1. use a map to track key and node.
     * 2. use double linked list to track least recent used.
     * */
    Map<Integer, ListNode> dict;
    ListNode head;
    ListNode tail;
    int capacity;
    public LRU(int capacity) {
        dict = new HashMap<>(capacity);
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!dict.containsKey(key))
            return -1;
        ListNode n = dict.get(key);
        moveNodeToTail(n);
        return n.val;
    }

    public void put(int key, int value) {
        if(dict.containsKey(key)){
            ListNode n = dict.get(key);
            n.val = value;
            moveNodeToTail(n);
        }
        else{
            //if full, remove first.
            if(dict.size() == capacity){
                dict.remove(head.next.key);
                removeAfter(head);
            }
            ListNode newN = new ListNode(value);
            //for each node, need to hold key information.
            //Because we need to remove from map, when we remove the first in list. we need the key information.
            newN.key = key;
            dict.put(key, newN);
            appendNode(newN);
        }
    }

    private void appendNode(ListNode node){
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }

    private void removeAfter(ListNode node){
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next.pre = node;
        temp.pre = null;
        temp.next = null;
    }

    private void moveNodeToTail(ListNode node){
        removeAfter(node.pre);
        appendNode(node);
    }

    public static void main(String[] args) {
        LRU lru = new LRU(1);
        lru.put(2,1);
        System.out.println(lru.get(2));
        lru.put(3,2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
    }


}

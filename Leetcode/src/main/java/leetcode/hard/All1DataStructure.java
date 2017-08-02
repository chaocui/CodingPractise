package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/6/11.
 */
public class All1DataStructure {
    /** Initialize your data structure here. */

    /**
     * O(1) operation,
     * Most of the O(1) operation can be done using HashMap tracking the node position(or node itself),
     * and double linked list to insert before or after the node.
     *
     * For this particular question
     * We can have a Node structure.
     * which hold the count of list of keys, and key set to hold all keys,
     * also have pre and next pointer to form double linked list.
     *
     * 双链表 在keep track of Node的情况下， O(1) 的insert 跟 delete 很牛逼的...
     * */
    public class Node{
        int count;
        Node next, pre;
        Set<String> keySet;
        public Node(int count){
            this.count = count;
            keySet = new HashSet<>();
        }
    }

    Node head, tail;
    //Count to Node map, so based on a key, from keyToCount and then countToNode, we can find node in O(1)
    Map<Integer, Node> countToNode;
    //Key to count map, to check if key exist.
    Map<String, Integer> keyToCount;

    public All1DataStructure() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        countToNode = new HashMap<>();
        keyToCount = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        //if exist, add 1 to count.
        if(keyToCount.containsKey(key)){
            changeKeyCount(key, 1);
        }
        /**
         * If does not exist, if head.next count is 1. we add to head.next,
         * otherwise create a new node and insert to head.next.
         * */
        else{
            keyToCount.put(key, 1);
            if(head.next.count != 1){
                Node newNode = new Node(1);
                //don't forget to add key and count to two maps if they are not exist.
                countToNode.put(1, newNode);
                insertAfter(head, newNode);
            }
            head.next.keySet.add(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyToCount.containsKey(key)){
            if(keyToCount.get(key) == 1){
                keyToCount.remove(key);
                removeKeyFromNode(key, countToNode.get(1));
            }
            else
                changeKeyCount(key, -1);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" : (String)tail.pre.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail? "" : (String)head.next.keySet.iterator().next();
    }

    /*
    * Delegate all general change key count operation to this method.
    * Handle delete or creation in specific method.
    * */
    public void changeKeyCount(String key, int offset){
        int currentCount = keyToCount.get(key);
        int newCount = currentCount + offset;
        Node currentNode = countToNode.get(currentCount);
        keyToCount.put(key, newCount);
        Node newNode;
        if(!countToNode.containsKey(newCount)){
            newNode = new Node(newCount);
            countToNode.put(newCount, newNode);
            if(offset == 1)
                insertAfter(currentNode, newNode);
            else
                insertAfter(currentNode.pre, newNode);
        }
        else
            newNode = countToNode.get(newCount);
        //remove key at last step because this may remove the node potentially,
        //but we need the node to do insert. so remove at last step.
        newNode.keySet.add(key);
        removeKeyFromNode(key, currentNode);
    }

    private void insertAfter(Node node, Node newNode){
        newNode.next = node.next;
        node.next.pre = newNode;
        newNode.pre = node;
        node.next = newNode;
    }

    //when move key from node
    //if node keyset count is 0, remove node from list.
    //remove countToNode from map.
    private void removeKeyFromNode(String key, Node node){
        node.keySet.remove(key);
        if(node.keySet.size() == 0) {
            countToNode.remove(node.count);
            removeNode(node);
        }
    }

    //double linked list remove Node --- so easy!!!
    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    public static void main(String[] args) {
        All1DataStructure a1 = new All1DataStructure();
        a1.inc("a");
        a1.inc("b");
        a1.inc("b");
        a1.inc("b");
        a1.inc("b");
        a1.dec("b");
        a1.dec("b");
        System.out.println(a1.getMaxKey());
        System.out.println(a1.getMinKey());
    }
}

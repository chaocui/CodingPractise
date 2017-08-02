package leetcode.hard;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by cc on 2017/4/30.
 */
public class LFUCache {

    /**
     * Same as LRU
     * Use a Deque to track count and under this count, sort by least recently used.
     *
     * 1. Need a hash map to keep track of key-value pairs. instead of only store value, we need to store value and count.
     * update the count to count + 1
     * 2. Another hash map to keep track of key-node paris
     *
     * Multiple keys can pointing to the same node.
     *  Node is a node which hold
     *  1. Count of frequency of each key which pointing to this node.
     *  Basically, all keys pointing to this node has the same frequency
     *  2. ListHashSet of keys that has the same count, they are in LRU order. First is the least recently used.
     *
     * Basically, the structure here is
     * 1. Hash map get key values
     * 2. Multiple keys pointing to the same node which has the same count of each keys in the node.
     *
     * Every time, a key is referenced, we just increase the count of the key.
     * How to:
     * 1. Get the node of current key.
     * 2. check if the following node of the current node has count > 1, if not , create a new node with count +1.
     * add key to the newly created node.
     * Remove key from current node.
     * Remove key from the key-value hash map.
     * add key node to other hash map.
     *
     * If reach capacity.
     * Remove head keys first.
     * If keys empty, remove head.
     * Then do the same thing.
     * 1. Check if the one we need to put exist or not.
     * If yes, increase count.
     * if not, check head count is 1 or not.
     * if not 1, create node, make new head.
     * if yes, add key to head. and add key value and key node to both hash map.
     * */
Deque deque = new LinkedList();
LinkedHashSet<Integer> keys = new LinkedHashSet<Integer>();
    {}
}

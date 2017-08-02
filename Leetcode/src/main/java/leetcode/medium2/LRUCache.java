package leetcode.medium2;

import java.util.*;

/**
 * Created by cc on 2017/4/29.
 */
public class LRUCache {

    Map<Integer, Integer> dict;
    List<Integer> freq;
    int capacity;

    public LRUCache(int capacity) {
        dict = new HashMap<>(capacity);
        freq = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    //When get, need to move in List the list to the head.
    //get index first.
    //then remove object at the index.
    //then add object to the end.
    public int get(int key) {
        Integer result = dict.get(key);
        if(result == null) return -1;
        freq.remove(freq.indexOf(key));
        freq.add(key);
        return result;
    }

    public void put(int key, int value) {
        //if exist, just update and move to the end.
        if(dict.containsKey(key)){
            dict.put(key,value);
            freq.remove(freq.indexOf(key));
            freq.add(key);
        }
        //if not.
        //if reach capacity. remove first one.
        //add to dict any way.
        else{
            if(freq.size() == this.capacity){
                int rmKey = freq.get(0);
                dict.remove(rmKey);
                freq.remove(0);
            }
            dict.put(key,value);
            freq.add(key);
        }
    }

}

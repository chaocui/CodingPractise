package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/10.
 */
public class LRUCache {

    /**
     * So basically, remove from hash map, just directly use key to remove.
     * remove from list, based on key, we get the index first, then remove it.
     * */
    Map<Integer, Integer> dict;
    List<Integer> list;
    int cap;
    public LRUCache(int capacity) {
        dict = new HashMap<>(capacity);
        list = new ArrayList<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if(!dict.containsKey(key)) return -1;
        int result = dict.get(key);
        //make it most recently used.
        list.remove(list.indexOf(key));
        list.add(key);
        return result;
    }

    public void put(int key, int value) {
        if(dict.containsKey(key)){
            //if exist, update value,
            //move to most recently used.
            dict.put(key, value);
            list.remove(list.indexOf(key));
            list.add(key);
        }

        else {
            if (list.size() == cap) {
                int rKey = list.get(0);
                dict.remove(rKey);
                list.remove(0);
            }
            dict.put(key,value);
            list.add(key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}

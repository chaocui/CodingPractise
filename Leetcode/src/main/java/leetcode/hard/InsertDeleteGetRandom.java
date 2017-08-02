package leetcode.hard;

import java.util.*;

/**
 * Created by cc on 2017/4/8.
 */
public class InsertDeleteGetRandom {
    /** Initialize your data structure here. */
    /**
     * Basic idea is.
     * use hashmap to keep track the position of each inserted value.
     * When remove, if the position is last element, remove it.
     * if not, then swap the value with last element, then remove.
     *
     * !!!!!!!!!!!!The important idea here is to track the position of each element.
     * each insert just append the element to make sure O(1)
     * When delete, we check if the location is last, if yes, just remove,
     * if not, we set the location to be the last value, then remove last., also make sure O(1)
     * */
    Map<Integer, Integer> location;
    List<Integer> dict;
    Random r;
    public InsertDeleteGetRandom() {
        location = new HashMap<>();
        dict = new LinkedList<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(location.containsKey(val)) return false;
        dict.add(val);
        location.put(val, dict.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!location.containsKey(val)) return false;
        int l = location.get(val);
        //if not the last element, swap with the last one.
        //set current location to be the last one. then delete the last one.
        //also update the last element position to be the location we got.
        if(l != dict.size() - 1) {
            int last = dict.get(dict.size() - 1);
            dict.set(l, last);
            location.put(last, l);
        }

        location.remove(val);
        dict.remove(dict.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        //get a index for the ArrayList
        int l = r.nextInt(dict.size());
        return dict.get(l);
    }
}

package leetcode.Pinterest;

import java.util.*;

/**
 * Created by cc on 2017/7/4.
 */
public class DesignPhoneDirectory {

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    /**
     * It does not require equal posibility.
     * Use a queue to save all numbers?
     * */
    Set<Integer> used;
    int bound;
    Queue<Integer> queue;
    public DesignPhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        this.bound = maxNumbers;
        queue = new LinkedList<>();
        for(int i = 0; i < maxNumbers ; i++)
            queue.offer(i);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(queue.isEmpty())
            return -1;
        int result = queue.poll();
        used.add(result);
        return result;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number < 0 || number >= bound) return false;
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        //if already in used. remove from set, and add back to queue.
        if(used.contains(number)) {
            used.remove(number);
            queue.offer(number);
        }
    }
}

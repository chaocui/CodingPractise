package leetcode.Linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/6/25.
 */
public class TwoSumIIIDSDesign {

    /** Initialize your data structure here. */
    /*
    * Use a hash set,
    * when do find, loop through set.
    * Add O(1), find O(n)
    * */
    Map<Integer,Integer> track;
    public TwoSumIIIDSDesign() {
        track = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        track.put(number, track.getOrDefault(number, 0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Set<Integer> keys = track.keySet();
        for(int key : keys){
            int difference = value - key;
            if(difference != key && track.containsKey(difference))
                return true;

            else if(difference == key && track.get(difference) > 1)
                return true;
        }
        return false;
    }
}

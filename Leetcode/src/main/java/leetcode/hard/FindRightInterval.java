package leetcode.hard;

import leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cc on 2017/3/26.
 */
public class FindRightInterval {

    /**
     * Straight forward treeMap solution.
     * just use treeMap ceilingEntry.
     *
     * ceiling returns the smallest one that greater than the input key.
     * floor returns the largest one that smaller than the input key.
     * */
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for(int i = 0; i < intervals.length; i++)
            treeMap.put(intervals[i].start, i);

        for(int i = 0; i < intervals.length; i++){
            Map.Entry<Integer, Integer> each = treeMap.ceilingEntry(intervals[i].end);
            result[i] = each == null ? -1 : each.getValue().intValue();
        }
        return result;
    }
}

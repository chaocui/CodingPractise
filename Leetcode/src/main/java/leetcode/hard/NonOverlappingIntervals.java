package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cc on 2017/3/25.
 */
public class NonOverlappingIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * basically, just find the maximum non-overlapping intervals.
     * sort intervals based on end.
     * if start >= previous end, not overlapping.
     * update end.
     * */
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        //if size > 0, at least 1 non-overlapping, which is the first interval.
        int count = 1;
        Arrays.sort(intervals, new IntervalComparator());
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start >= end){
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }

    public class IntervalComparator implements Comparator<Interval>{

        //compare end, if equal, compare start.
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.end - o2.end == 0? o1.start - o2.start : o1.end - o2.end;
        }
    }
}

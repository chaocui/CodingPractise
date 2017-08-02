package leetcode.Pinterest;

import leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cc on 2017/6/20.
 */
public class MergeInterval {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
            }
        });
        Interval i = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(Interval interval : intervals){
            if(interval.start > i.end){
                result.add(new Interval(i.start, i.end));
                i.start = interval.start;
                i.end = interval.end;
            }
            else{
                i.start = Math.min(i.start, interval.start);
                i.end = Math.max(i.end, interval.end);
            }
        }
        result.add(i);
        return result;
    }

    public List<Interval> merge1(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
            }
        });
        for(Interval interval : intervals){
            if(result.size() == 0) result.add(interval);
            Interval last = result.get(result.size() - 1);
            if(last.end >= interval.start)
                last.end = Math.max(interval.end,last.end);
            else
                result.add(interval);
        }
        return result;
    }
}

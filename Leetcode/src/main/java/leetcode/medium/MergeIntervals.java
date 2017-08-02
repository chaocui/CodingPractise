package leetcode.medium;

import leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cc on 2017/2/18.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
               return o1.start - o2.start;
            }
        });
        for(Interval i : intervals){
            if(result.size() == 0) result.add(i);
            Interval last = result.get(result.size() - 1);
            if(i.start > last.end)
                result.add(i);
            else if(i.end > last.end)
                last.end = i.end;
        }
        return result;
    }

    public static void main(String[] args){
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(0,4);
        List<Interval> test = new ArrayList();
        test.add(i1);
        test.add(i2);

        MergeIntervals mi = new MergeIntervals();
        mi.merge(test);
    }

}

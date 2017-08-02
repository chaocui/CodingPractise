package leetcode.Lyft;

import leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cc on 2017/6/26.
 */
public class FindTheHourMostDriverActive {

    /**
     * Same as Facebook 面经
     * find the point that has maximum interval overlapping.
     *
     * two solution.
     * 1. loop through intervals, find max and min.
     *    create array with size max - min + 1;
     *    loop through each interval, from start to end, add count to corresponding array index.
     *    loop through array, find max count.
     * 2. pre-process input.
     *    start time 0, end time 1.
     *    sort this pre-processed array. by start time. if same, sort by end.
     *    every time we meeting start, count++, we meeting end count --.
     * */

    public int solution(List<Interval> intervals){
        List<int[]> preProcess = new ArrayList<>();
        for(Interval i : intervals){
            preProcess.add(new int[]{i.start, 0});
            preProcess.add(new int[]{i.end, 1});
        }

        Collections.sort(preProcess, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] -  o2[0];
            }
        });

        int count = 0, max = Integer.MIN_VALUE;
        int result = 0;
        for(int[] each : preProcess){
            if(each[1] == 0) count++;
            else count--;
            if(count > max){
                result = each[0];
                max = count;
            }
        }
        //return how many drivers.
        return max;
        //return what time.
        //return result;
    }
}

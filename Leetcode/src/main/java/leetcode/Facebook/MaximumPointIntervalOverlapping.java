package leetcode.Facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cc on 2017/6/7.
 */
public class MaximumPointIntervalOverlapping {
    /**
     *  Two solutions
     *  1. find min and max in all intervals.
     *  create array size of max - min + 1;
     *  2. For each interval, loop through from start to end.
     *  increase count in the array.
     *  3. Find the maximum count index in the array.
     * */
    public int solution(int[][] intervals){
        if(intervals == null || intervals.length == 0) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] interval : intervals){
            min = Integer.min(interval[0],min);
            max = Integer.max(interval[1],max);
        }
        int[] count = new int[max-min+1];
        for(int[] interval : intervals){
            for(int i = interval[0]; i < interval[1]; i++)
                count[i-min]++;
        }

        int result = 0;
        for(int i : count)
            result = Math.max(i, count[i]);

        return result+min;
    }

    /**
     * Solution 2.
     * 1. Pre-process input, [startNumber, 1], [endNumber, 0]
     * 2. sort this processed data. if equal, compare 1 and 0(start has higher priority)
     * 3. loop through sorted, start +1, end - 1, keep track of maximum.
     * */
    public int solution1(int[][] intervals){
        List<int[]> timeSpot = new ArrayList<>();
        for(int[] interval : intervals){
            timeSpot.add(new int[]{interval[0], 0});
            timeSpot.add(new int[]{interval[1], 1});
        }

        Collections.sort(timeSpot, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int count = 0, max = 0, result = -1;
        for(int[] i : timeSpot){
            if(i[1] == 0) count++;
            else count--;
            //if current result > max, we update result, and also update max.
            if(count > max){
                result = i[0];
                max = count;
            }
        }
        return result;
    }

}

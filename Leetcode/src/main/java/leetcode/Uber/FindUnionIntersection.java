package leetcode.Uber;

import java.util.List;

/**
 * Created by cc on 2017/6/15.
 */
public class FindUnionIntersection {


    public int[] union(List<int[]> intervals, int[] input){

        int[] result = new int[2];
        result[0] = input[0];
        result[1] = input[1];

        /**
         * Basic idea
         * compare result with current interval.
         * if result[0] > interval[1] || result[1] < interval[0]
         * skip.
         * else merge update result.
         * */
        for(int[] interval : intervals){
            if(result[0] >= interval[1] || result[1] <= interval[0])
                continue;
            else{
                result[0] = Math.min(result[0], interval[0]);
                result[1] = Math.max(result[1], interval[1]);
            }
        }
        return result;
    }

    public int[] intersect(){
        return null;
    }

}

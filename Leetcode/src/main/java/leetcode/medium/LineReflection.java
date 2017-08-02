package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cc on 2017/5/20.
 */
public class LineReflection {

    //Basic idea
    //any two reflection points, their sum are the same as other reflect sums.
    //so use a HashSet to keep track of all points. as xValue + a + yValues.
    //loop through all points.
    //use sum - xValue + a +　yValues, if this key does not exists than this point has no refelction points.
    public boolean isReflected(int[][] points) {
        Set<String> dict = new HashSet();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min,p[0]);
            dict.add(p[0] + "a" + p[1]);
        }

        int sum = min+max;
        for(int[] p: points){
            String s = (sum - p[0]) + "a" + p[1];
            if(!dict.contains(s)) return false;
        }
        return true;
    }

}

package leetcode.medium;

/**
 * Created by cc on 2017/4/1.
 */
public class TeemoAttacking {

    /**
     * Basic idea,
     * check difference between two time point.
     * if it is greater than duration, then just add duration.
     * if less than duration, then add the difference.
     * */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if(len == 0) return 0;
        int result = 0;
        for(int i = 1; i < len; i++){
            int difference = timeSeries[i] - timeSeries[i-1];
            if(difference < duration) result += difference;
            else result += duration;
        }
        return result + duration;
    }


}

package leetcode.Pinterest;

/**
 * Created by cc on 2017/7/4.
 */
public class DesignHitCounter {
    /** Initialize your data structure here. */
    /*
    * Since everything is called increasingly,
    * we only need to save last 300s hits, because when we call get hits,
    * it always increased time/seconds.
    * */
    int[] hits;
    int[] times;
    public DesignHitCounter() {
        hits = new int[300];
        times = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    //index 0, is 300s.
    /**
     * if they fit into the same pos, means that this is 300s later.
     * */
    public void hit(int timestamp) {
        int pos = timestamp%300;
        if(times[pos] != timestamp){
            times[pos] = timestamp;
            hits[pos] = 1;
        }
        else
            hits[pos]++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int result = 0;
        for(int i = 0; i < 300; i++){
            //timestamp always the latest/largest number
            if(timestamp - times[i] < 300)
                result += hits[i];
        }
        return result;
    }
}

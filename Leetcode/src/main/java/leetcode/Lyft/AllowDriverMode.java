package leetcode.Lyft;

import leetcode.util.Interval;

import java.util.List;

/**
 * Created by cc on 2017/6/26.
 */
public class AllowDriverMode {

    public boolean solution(List<Interval> intervals){

        int length = intervals.size();
        int drive = intervals.get(length-1).end - intervals.get(length-1).start;
        int sleep = 0;
        for(int i = length-2; i>=0; i++){
            //here we check how long we drive after the previous sleep.
            //if greater than 12, we cannot drive no matter how long we sleep.
            //if less than 12, then check how long we sleep.
            if(drive >= 12) return false;
            Interval current = intervals.get(i);
            Interval next = intervals.get(i+1);
            sleep = next.start - current.end;
            //if sleeps >= 8, and the follow drive after sleep are not 12 hours. can drive.
            if(drive < 12 && sleep >= 8)
                return true;
            //not satisfy, add current drive
            drive = drive + current.end - current.start;
        }
        return false;
    }
}

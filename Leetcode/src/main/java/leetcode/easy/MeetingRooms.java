package leetcode.easy;

import leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cc on 2017/5/24.
 */
public class MeetingRooms {
    //same as meetingRoomII
    //just see how many rooms, if more than 1, then no.

    //This can be easier, just sort, compare current meeting start with previous meeting end.
    //if overlap, then cannot
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        if(intervals.length == 1) return true;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }
}

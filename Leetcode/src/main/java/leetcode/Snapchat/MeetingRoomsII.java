package leetcode.Snapchat;

import leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/6/22.
 */
public class MeetingRoomsII {

    /**
     * Basic idea is
     * 1. sort the input intervals based on start time.
     * 2. use min heap to keep track of end time.
     * 3. put into first meeting.
     * loop through other meetings.
     * if start time >= end time. then can reuse the room.
     * then update the end time.
     * (after update end time, heap will be restructured, first end meeting will be the top)
     * otherwise, need a new room, just put meeting into heap.
     *
     * */
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        //first of all, sort by start time, the input array.
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        PriorityQueue<Interval> minHeap = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        minHeap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval currentMeeting = intervals[i];
            Interval topMeeting = minHeap.poll();
            if(currentMeeting.start < topMeeting.end)
                minHeap.offer(currentMeeting);
            else{
                topMeeting.end = currentMeeting.end;
            }
            minHeap.offer(topMeeting);
        }
        return minHeap.size();
    }

}

package leetcode.medium;

import leetcode.util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/5/23.
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
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        minHeap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval interval = minHeap.poll();
            //if current meeting end < new meeting start.
            //so re use the room, update this rooms end
            if(interval.end <= intervals[i].start)
                interval.end = intervals[i].end;
            else
                minHeap.offer(intervals[i]);
            //put the meeting back, either updated or not.
            minHeap.offer(interval);
        }
        return minHeap.size();
    }
}

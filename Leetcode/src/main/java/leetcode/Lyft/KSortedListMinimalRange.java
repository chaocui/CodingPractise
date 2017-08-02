package leetcode.Lyft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/6/26.
 */
public class KSortedListMinimalRange {

    public class Track{
        int outIndex, inIndex;
        public Track(int outIndex, int inIndex){
            this.outIndex = outIndex;
            this.inIndex = inIndex;
        }
    }

    public int solution(List<List<Integer>> input){
        PriorityQueue<Track> minHeap = new PriorityQueue<>(new Comparator<Track>() {
            @Override
            public int compare(Track o1, Track o2) {
                return input.get(o1.outIndex).get(o1.inIndex) - input.get(o2.outIndex).get(o2.inIndex);
            }
        });

        //indicate how many list are non-empty.
        int count = 0;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i).size() > 0) {
                count++;
                minHeap.offer(new Track(i, 0));
            }
        }

        List<Integer> result = new ArrayList<>();
        int[] visited = new int[input.size()];
        int start = 0, end = 0, rangeStart = Integer.MIN_VALUE, rangeEnd = Integer.MAX_VALUE;
        while(!minHeap.isEmpty()){
            Track current = minHeap.poll();
            end ++;
            int out = current.outIndex;
            int in = current.inIndex;
            result.add(input.get(out).get(in));
            if(visited[out] == 0)
                count --;
            visited[out]++;
            if(input.get(out).get(in) + 1 < input.get(out).size()) {
                minHeap.add(new Track(out, in+1));
            }
            while(count == 0){
                /**
                 * if the visited time hits 1, then we move start, means the new start wont cover all elements from each array.
                 * so we increase count to break the loop.
                 * */
                if(visited[start] == 1)
                    count ++;
                visited[start] --;
                /**
                 * Before we out of the loop, we update the rangeStart and rangeEnd if we need to.
                 * if count != 0, means current start is the one causing break the loop.
                 * so this is the new start.
                 * check if the range is smaller. update the result accordingly.
                 * */
                if(count != 0){
                    if(end - start < rangeEnd - rangeStart){
                        rangeStart = start;
                        rangeEnd = end;
                    }
                }
                start++;
            }
        }
        return rangeEnd - rangeStart;
    }
}

package leetcode.hard;

import java.util.*;

/**
 * Created by cc on 2016/11/7.
 */
public class TheSkylineProblem {

    /**
     * pre process buildings.
     * make them [left, height], [right, -height]
     * use a heap to track the current maximum height.
     *
     * sort the pre processed arrays.
     * if equals, left goes first. left is greater, so we sort descending order.
     *
     * loop through th array.
     * proper process see code below.
     * */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> positions = new ArrayList<>();
        for(int[] b : buildings){
            int[] left = new int[]{b[0],b[2]};
            int[] right = new int[]{b[1],-b[2]};
            positions.add(left);
            positions.add(right);
        }
        Collections.sort(positions, new Comparator<int[]>() {
            @Override
            //left goes first. 3 2 1 -- descending order.
            //if equal, big goes first.
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        List<int[]> result = new ArrayList<>();
        maxHeap.add(0);
        //use to keep track of previous height.
        //we can determine if the same height get extended. if not, we add current position and peek to result.
        //update previous.
        int previousH = 0;
        for(int[] p : positions){
            if(p[1] > 0)
                maxHeap.add(p[1]);
            else
                maxHeap.remove(-p[1]);

            if(previousH != maxHeap.peek()) {
                result.add(new int[]{p[0], maxHeap.peek()});
                previousH = maxHeap.peek();
            }
        }
        return result;
    }
}

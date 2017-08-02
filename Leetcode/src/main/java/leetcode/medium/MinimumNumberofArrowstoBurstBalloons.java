package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by cc on 2017/3/28.
 */
public class MinimumNumberofArrowstoBurstBalloons {

    //use stack to process,
    //basically, sort the input,
    //compare new element with stack top, if start > end, push to stack
    //else, update stack top as start as bigger one, end as smaller one.
    //return stack size
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Stack<int[]> stack = new Stack<int[]>();
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o1[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        stack.push(points[0]);
        for(int i = 1; i < points.length; i++){
            int[] peek = stack.peek();
            int[] newE = points[i];
            if(newE[0] > peek[1]) stack.push(newE);
            else{
                peek[0] = Math.max(peek[0],newE[0]);
                peek[1] = Math.min(peek[1],newE[1]);
            }
        }
        return stack.size();
    }

}

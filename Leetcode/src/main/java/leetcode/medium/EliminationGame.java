package leetcode.medium;

/**
 * Created by cc on 2017/3/22.
 */
public class EliminationGame {
    /**
     * Basic idea,
     * Keep track of head.
     * when update head.
     * 1. going left to right, always update head.
     * 2. going right to left, if odd numbers left, update head.
     * Keep updating steps. steps = steps * 2;
     * */
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean left = true;
        while(remaining > 1){
            if(left || remaining % 2 == 1){
                head = head + step;
            }
            step = step*2;
            remaining = remaining / 2;
            left = !left;
        }
        return head;
    }
}

package LeetcodeSecondTime.hard;

/**
 * Created by cc on 2016/11/14.
 */
public class KthSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        int current = 1;
        //Find kth, move k - 1
        int move = k - 1;
        while(move > 0){
            int steps = steps(n, current, current+1);
            if(steps > move){
                current = current*10;
                move = move - 1;
            }
            else{
                current = current + 1;
                move = move - steps;
            }
        }
        return current;
    }

    public int steps(int boundary, long current, long next){
        int result = 0;
        //Even if equals boundary, need to go through loop one more to add 1.
        while(current <= boundary){
            result+=(Math.min(next, boundary+1) -  current);
            //Keep moving to next level until current > boundary
            current *= 10;
            next *= 10;
        }
        return result;
    }
}

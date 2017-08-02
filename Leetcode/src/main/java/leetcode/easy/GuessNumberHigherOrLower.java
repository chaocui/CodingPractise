package leetcode.easy;

/**
 * Created by cc on 2017/4/23.
 */
public class GuessNumberHigherOrLower {

    /**
     * Binary search
     * */
    public int guessNumber(int n) {
        int start = 0, end = n;
        while(start < end){
            //prevent overflow
            int mid = start + (end - start)/2;
            int guess = guess(mid);
            if(guess == -1){
                end = mid-1;
            }
            else if(guess == 1){
                start = mid+1;
            }
            else if(guess == 0)
                return mid;
        }
        return start;
    }

    private int guess(int num){
        return 0;
    }

}

package leetcode.easy;

/**
 * Created by cc on 2017/4/23.
 */
public class ArrangingCoins {

    /**
     * This is like
     * Fresh year C programming home work!
     * Way too easy...
     * */
    public int arrangeCoins(int n) {
        int result = 0, i = 1;
        while(true){
            if(n >= i)
                result++;
            else
                break;
            n = n - i;
            i++;
        }
        return result;
    }
}

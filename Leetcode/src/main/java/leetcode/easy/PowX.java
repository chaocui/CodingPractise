package leetcode.easy;

/**
 * Created by cc on 2017/5/28.
 */
public class PowX {

    /**
     * Difficult part is consider overflow. which is n = Integer.MIN_VALUE;
     * */
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            /**
             * if n is minimum integer, it will overflow if just do n = -n.
             * so we add 1 to n, and flip. then when we calculate, we multiply one more x.
             * */
            if(n == Integer.MIN_VALUE){
                n++;
                n = -n;
                x = 1/x;
                return myPow(x*x, n/2)*x*x;
            }
            n = -n;
            x = 1/x;
        }
        return n%2==0? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}

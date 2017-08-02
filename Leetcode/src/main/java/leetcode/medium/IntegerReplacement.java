package leetcode.medium;

/**
 * Created by cc on 2016/11/22.
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        return (int)longReplacement(n);
    }

    public long longReplacement(long n) {
        if( n < 3 ) return n - 1;
        if(n%2 ==0) return longReplacement(n/2) + 1;
        else return Math.min(longReplacement(n-1),longReplacement(n+1)) + 1;
    }

}

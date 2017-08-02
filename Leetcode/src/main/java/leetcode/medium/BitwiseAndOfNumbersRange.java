package leetcode.medium;

/**
 * Created by cc on 2017/3/9.
 */
public class BitwiseAndOfNumbersRange {

    //basic idea is
    //if m and n has the same number of bits.
    //we keep moving until m = n means that find the common prefix of m and n.
    //then we keep track how many bits we shift. we multiplay m * factor.

    //if m has less bit than n,
    //then m == n has to be m = 0;
    //and result should be 0. since m has less bits, means that all extra bits n has will & to 0,
    //also the common parts will & to 0 . since there must be a number has (1 and 0s(0 will be the same number as the number of bits in m)) between m and n.
    public int rangeBitwiseAnd(int m, int n) {
        int factor = 1;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            factor = factor << 1;
        }
        return m * factor;
    }

    public static void main(String[] args){
        System.out.println(1>>1);
    }

}

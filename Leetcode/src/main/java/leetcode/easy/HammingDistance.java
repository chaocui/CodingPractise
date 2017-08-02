package leetcode.easy;

/**
 * Created by cc on 2017/5/28.
 */
public class HammingDistance {

    //x XOR y, count the number of 1s
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int result = 0;
        for(int i = 0; i < 32; i++){
            result += z & 1;
            z = z >> 1;
        }
        return result;
    }
}

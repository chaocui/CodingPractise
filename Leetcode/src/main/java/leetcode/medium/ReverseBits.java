package leetcode.medium;

/**
 * Created by cc on 2017/3/10.
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            result = result + (n & 1);
            n >>>= 1;
            //No need to shift the last bit.
            //if shift, will be wrong.
            //Since shift 31 times will leave the right most be 0 and just + the last bit will be the result.
            //So no more shift when i = 31.
            if(i < 31)
                result <<= 1;
        }
        return result;
    }

    //If this function will be called multiple time.
    //we can split the integer into 4 bytes
    //we can cache each byte's reverse.
    //Every time we can search for cache.
}

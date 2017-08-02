package leetcode.hard;

/**
 * Created by cc on 2017/5/28.
 */
public class ReadNCharactersGivenRead4IIMultipleTimes {

    /**
     * Use two variable to track previous call status.
     * 1. where the pointer is in the read4 buffer.
     * 2. how many chars are read by read4 method.
     *
     * Explain of one call and multiple calls
     * https://discuss.leetcode.com/topic/36179/what-is-the-difference-between-call-once-and-call-multiple-times
     * */
    private int buffPos = 0;
    private int buffCount = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int pos = 0;
        while(pos < n){
            //buffPos is 0, means we did not read nothing. so we read
            if(buffPos == 0)
                buffCount = read4(buff);
            //if buffCount is 0, means we have no more to read, so break;
            if(buffCount == 0) break;

            //we have to satisfy not exceeding n, and also only copy what we read, so < buffCount
            while(pos < n && buffPos < buffCount)
                buf[pos++] = buff[buffPos++];
            //if we copied everything, reset buffPos,
            //if not, means we read the maximum chars, so keep track of whats left in buff,
            //copy in the next call first.
            if(buffPos == buffCount) buffPos = 0;
        }
        return pos;
    }

    int read4(char[] buf){return 0;}

}

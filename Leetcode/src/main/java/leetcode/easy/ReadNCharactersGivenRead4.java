package leetcode.easy;

/**
 * Created by cc on 2017/5/24.
 */
public class ReadNCharactersGivenRead4 {

    /**
     * Need to manually copy from temp buffer to destination buffer.
            * */
    public int read(char[] buf, int n) {
        int result = 0;
        boolean done = false;
        //keep reading if there are more than 3 left.
        while(!done && result < n){
            //read from file.
            char[] temp = new char[4];
            //how many chars we read
            int r = read4(temp);
            //if less than 4, means that no more data can be read.
            if(r < 4) done = true;
            //this step is important, if number we can read is less than what we actually read, take what we can read.
            //senario of file is big, but n is small.
            //check how many more we can read versus what we read.
            r = Math.min(r, n - result);
            //copy temp to target buffer.
            for(int i = 0; i < r; i++)
                buf[result++] = temp[i];
        }
        return result;
    }

    private int read4(char[] buf){
        return 0;
    }

}

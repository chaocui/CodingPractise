package leetcode.hard;

/**
 * Created by cc on 2017/4/18.
 */
public class SuperWashingMachines {
    //This solution is so fking tricky.

    /**
     * Dont know how to explain.
     * Refer to the leetcode link.
     * https://discuss.leetcode.com/topic/79938/super-short-easy-java-o-n-solution
     * */
    public int findMinMoves(int[] machines) {
        int total = 0;
        int len = machines.length;
        for(int n : machines) total += n;
        if(len == 0 || total%len != 0) return -1;
        int avg = total/len;
        int result = 0, needed = 0;
        for(int load : machines){
            needed += load - avg;
            result = Math.max(Math.max(result, Math.abs(needed)), load-avg);
        }
        return result;
    }
}

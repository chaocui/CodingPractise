package leetcode.medium;

/**
 * Created by cc on 2016/7/17.
 */
public class BuldSwitch {
    public int bulbSwitch(int n) {
        int result = 0;
        int i = 1;
        while(i*i <= n){
            result++;
            i ++;
        }
        return result;
    }
}

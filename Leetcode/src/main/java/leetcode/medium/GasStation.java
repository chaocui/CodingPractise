package leetcode.medium;

/**
 * Created by cc on 2016/7/14.
 */
public class GasStation {
    //http://bookshadow.com/weblog/2015/08/06/leetcode-gas-station/
    //Pretty good explanation(proof)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sum = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}

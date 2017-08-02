package TwoSigma.Afternoon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2016/8/27.
 */
public class UglyNumber {

    public int nthUgly(int n) {
        List<Integer> ugly = new ArrayList<Integer>();
        ugly.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (ugly.size() <= n) {
            int temp2 = ugly.get(index2) * 2;
            int temp3 = ugly.get(index3) * 3;
            int temp5 = ugly.get(index5) * 5;

            int nextUgly = Math.min(temp2, Math.min(temp3, temp5));
            if (nextUgly == temp2) {
                index2++;
            } else if (nextUgly == temp3) {
                index3++;
            } else {
                index5++;
            }

            ugly.add(nextUgly);
        }
        return ugly.get(n - 1);
    }
}

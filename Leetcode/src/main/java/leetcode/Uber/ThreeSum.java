package leetcode.Uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/14.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] a1, int[] a2, int[] a3, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < a1.length; i++){
            //make it easy, once equal, move both pointer
            int diff = target - a1[i];
            for(int m = 0, n = a3.length-1; m < a2.length && n >= 0;){
                if(a2[m] + a3[n] > diff)
                    n--;
                else if(a2[m] + a3[n] < diff)
                    m++;
                else{
                    List<Integer> each = new ArrayList<>();
                    each.add(a1[i]);
                    each.add(a2[m]);
                    each.add(a3[n]);
                    result.add(each);
                    m++;
                    n--;
                }
            }
        }
        return result;
    }

    /**
     * Solution 2, use more space.
     * for a2 and a3, we keep track of sum of every two elements, along with the combinations.
     * then loop a1 one time.
     *
     * So faster but space is more.
     * */
}

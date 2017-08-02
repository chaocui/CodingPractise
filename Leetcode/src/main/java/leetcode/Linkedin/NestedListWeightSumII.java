package leetcode.Linkedin;

import leetcode.util.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/7/31.
 */
public class NestedListWeightSumII {
    /**
     * [[1,1],2,[1,1]]
     * for this example,
     * we can see that
     * unfactored result = 2 -- first level
     * result = 2;
     * unfactored result = 2 + 1 + 1 + 1 + 1 = 6;
     * result = result + unfactoredResult = 8;
     *
     * basically, for each level, result add unfactored result.
     * for every level, unfactored result will just add that level value(flat the values for each level)
     * just like primaids
     * unfactorResult 2
     *                2 + 1 + 1 + 1 + 1
     *                2 + 1 + 1 + 1 + 1 + x + y + z
     * result just add each level unfactor result.
     * goes one level deeper, the previous will added one more time.
     * */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int result = 0, unfactoredResult = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> temp = new ArrayList<>();
            for(NestedInteger each : nestedList) {
                if (each.isInteger())
                    unfactoredResult += each.getInteger();
                else
                    //add all elements in list to next level, they might be integer, or list.
                    temp.addAll(each.getList());
            }

            result += unfactoredResult;
            nestedList = temp;
        }
        return result;
    }
}

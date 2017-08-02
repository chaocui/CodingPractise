package leetcode.Linkedin;

import leetcode.util.NestedInteger;

import java.util.List;

/**
 * Created by cc on 2017/7/31.
 */
public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        for(NestedInteger each : nestedList)
            result += getResult(each, 1);
        return result;
    }

    private int getResult(NestedInteger i, int level){
        if(i.isInteger())
            return i.getInteger()*level;
        int result = 0;
        for(NestedInteger each : i.getList())
            result += getResult(each, level+1);
        return result;
    }


}

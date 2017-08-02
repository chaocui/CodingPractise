package leetcode.Snapchat;

import leetcode.util.NestedInteger;

import java.util.List;

/**
 * Created by cc on 2017/6/18.
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        for(int i = 0; i < nestedList.size(); i++)
            result += countResult(1, nestedList.get(i));
        return result;
    }

    public int countResult(int level, NestedInteger ni){
        int result = 0;
        if(ni.isInteger())
            return level*ni.getInteger();
        else if(!ni.isInteger()){
            List<NestedInteger> l = ni.getList();
            for(NestedInteger n : l)
                result += countResult(level + 1, n);
        }
        return result;
    }


}

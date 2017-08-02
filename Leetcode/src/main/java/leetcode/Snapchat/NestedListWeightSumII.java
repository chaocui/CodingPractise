package leetcode.Snapchat;

import leetcode.medium.FlattenNestedListIterator;
import leetcode.util.NestedInteger;

import java.util.*;

/**
 * Created by cc on 2017/6/18.
 */
public class NestedListWeightSumII {

    /**
     * Basic idea is for each level, just filter out integers.
     * put these integers in a list and put this list into stack.
     * For non-integers, we add every elements in list to next level for next level processing.
     *
     * Do this until nestedList is empty.
     *
     * Then stack top level has level 1, and we keep increasing levels.
     * */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Stack<List<NestedInteger>> stack = new Stack<>();
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();
            List<NestedInteger> currentLevel = new ArrayList<>();
            for(NestedInteger ni : nestedList){
                if(!ni.isInteger())
                    nextLevel.addAll(ni.getList());
                else
                    currentLevel.add(ni);
            }
            stack.add(currentLevel);
            nestedList = nextLevel;
        }
        int level = 1, result = 0;
        while(!stack.isEmpty()){
            List<NestedInteger> each = stack.pop();
            for(NestedInteger i : each)
                result += (level * i.getInteger());
            level ++;
        }
        return result;
    }

    /**
     * Tricky solution.
     * Keep track of un-weighted sum.
     * So that,
     * when we go deep, the previous levels will be added multiple times.
     * */
    public int depthSumInverse1(List<NestedInteger> nestedList) {
        int result = 0, unweightedResult = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(NestedInteger ni : nestedList){
                if(ni.isInteger())
                    unweightedResult += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            result += unweightedResult;
            nestedList = nextLevel;
        }
        return result;
    }

}

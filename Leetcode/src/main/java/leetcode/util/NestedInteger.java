package leetcode.util;

import leetcode.Uber.FlattenNestedList;

import java.util.List;

/**
 * Created by cc on 2017/6/18.
 */
public class NestedInteger {

    public NestedInteger(){}

    public NestedInteger(int val){}

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return null;}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer

    public void setInteger(int value){}

    public void add(NestedInteger ni){}

    public List<NestedInteger> getList(){return null;}
}

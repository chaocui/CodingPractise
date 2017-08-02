package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/3/21.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> eachResult = new ArrayList<Integer>();
        getResult(eachResult, result, n, k , 1);
        return result;
    }

    private void getResult(List<Integer> eachResult, List<List<Integer>> result, int n, int k, int start){
        /**
         *  if k == 0, means current each Result is one of the result
         *  add it and return.
         * */
        if(k == 0){
            result.add(new ArrayList<Integer>(eachResult));
            return;
        }
        /**
         * if start goes out of scope, we return.
         * */
        if(start > n) return;

        //loop through from start to n,
        //add each i to result.
        //recursively call i+1,
        //then remove i from temp result.
        for(int i = start; i <= n; i++){
            eachResult.add(i);
            getResult(eachResult, result, n, k-1,i+1);
            eachResult.remove(eachResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        Combinations c = new Combinations();
        c.combine(4,2);
    }

}

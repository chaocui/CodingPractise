package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/6/8.
 */
public class FactorCombinations {

    /**
     *  Key part is remove duplication
     *  An easy solution is sort result, convert to string. see if it is in set already.
     *
     *
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempResult = new ArrayList<>();
        helper(result, tempResult, n, 2);
        return result;
    }

    /*
     * De-dup method is pretty smart.
     */
    //if we pass in start number.
    //every time start is > n, we just break. since the possible result must be generated before.
    //in this way, we can make sure the result array is in ascending order. any time start > n, we just ignore.
    //the possible result must be generated before.

    //when generating result, the numbers are sorted.
    //so once the start is greater than n, means this result must be generated before.
    public void helper(List<List<Integer>> result, List<Integer> tempResult, int n, int start){
        if(n <= 1){
            if(tempResult.size() > 1){
                result.add(new ArrayList<>(tempResult));
                return;
            }
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0) {
                tempResult.add(i);
                helper(result, tempResult, n / i, i);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    public void getResult(List<List<Integer>> result, List<Integer> tempResult, int n, Set<String> tracker){
        if(n <= 1){
            if(tempResult.size() > 1){
                String key = getKey(tempResult);
                if(tracker.add(key))
                    result.add(new ArrayList<>(tempResult));
                return ;
            }
        }

        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                tempResult.add(i);
                getResult(result, tempResult,n/i,tracker);
                //remove what we added for back tracing.
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    public String getKey(List<Integer> l){
        List<Integer> copy = new ArrayList<>(l);
        Collections.sort(copy);
        StringBuilder sb = new StringBuilder();
        for(int i : copy)
            sb.append(i).append("_");
        return sb.toString();
    }

    public static void main(String[] args) {
        FactorCombinations fc = new FactorCombinations();
        List<List<Integer>> result = fc.getFactors(32);
        for(List<Integer> r : result){
            for(int i : r){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

}

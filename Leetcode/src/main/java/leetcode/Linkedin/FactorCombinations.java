package leetcode.Linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/8/1.
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        getResult(n, 2, result, tempResult);
        return result;
    }

    public void getResult(int n, int start, List<List<Integer>> result, List<Integer> tempResult){
        if(n == 1){
            if(tempResult.size() > 1)
                result.add(new ArrayList<>(tempResult));
            return;
        }

        //this is how we remove dups,
        //we always find factors that greater than start.
        //initially start is 2.
        //then we increasing start, and the following factor will alwasy greater than start.
        //so we wont go backwards, which may lead to dups
        for(int i = start; i <= n; i++){
            if(n%i == 0){
                tempResult.add(i);
                getResult(n/i, i, result, tempResult);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }
}

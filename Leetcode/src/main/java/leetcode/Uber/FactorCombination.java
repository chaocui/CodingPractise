package leetcode.Uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/14.
 */
public class FactorCombination {

    /**
     * Back tracing.
     * */
    public List<List<Integer>> factorComb(int num){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        getResult(result, tempResult, num, 2);
        return result;
    }

    public void getResult(List<List<Integer>> result, List<Integer> tempResult, int num, int start){
        if(num == 1){
            if(tempResult.size() > 0)
                //here we need to copy the tempResult to result.
                result.add(new ArrayList<>(tempResult));
            return;
        }
        for(int i = start; i <= num; i++){
            if(num%i == 0){
                tempResult.add(i);
                getResult(result, tempResult, num/i, i);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }




}

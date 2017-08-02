package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/13.
 */
public class ArithmeticSlicesIISubsequence {

    /**
     * Now i feel like i am a genius!!!!!!!!!!!!!!!!!!
     * Must have solved too many back tracing issues. LOL
     *
     * The DAMN reality is those CPU/GPU brain people have
     * faster solutions!!!!!!!
     *
     * WTHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH!!!!!!
     * I am still an idiot, ESTUPIDO!!!!!!!!!!!!!!
     * */
    public int numberOfArithmeticSlices1(int[] A) {
        int[] result = new int[1];
        result[0] = 0;
        List<Integer> tempResult = new ArrayList<>();
        getResult(A,0,result,tempResult);
        return result[0];
    }

    private void getResult(int[] A, int start, int[] result, List<Integer> tempResult){
        //if tempResult has >=3 elements. increase result count.
        if(tempResult.size() >= 3){
            result[0]++;
        }
        //if out of bound, return.
        if(start == A.length) return;
        //loop though array
        for(int i = start; i < A.length; i++){
            //if no or 1 elements in tempResult, just add and recursive call.
            if(tempResult.size() <= 1){
                tempResult.add(A[i]);
                getResult(A, i+1,result,tempResult);
                tempResult.remove(tempResult.size()-1);
            }
            //otherwise need to make sure its arithmetic
            else{
                long diff = (long)tempResult.get(tempResult.size() - 1) - (long)tempResult.get(tempResult.size() - 2);
                if(diff == (long)A[i]-tempResult.get(tempResult.size() - 1)){
                    tempResult.add(A[i]);
                    getResult(A, i+1,result, tempResult);
                    tempResult.remove(tempResult.size() - 1);
                }
            }
        }
    }

    /**
     * Sort of DP
     *
     * So basic idea is
     * use map to track to each index, number of arithmetic sequence.
     *
     * inner loop will loop through from 0 to i.
     * check every difference between i and j.
     * Check existing map[i] if there are any,
     * Check existing map[j] if there are any.
     * if there any map[j], means to j we have this difference with number cj.
     * so we add i to all map[j] we still form cj numbers of sequence.
     * and now they are till i. so we acummulate ci and cj.
     *
     * The reason why we add 1 is
     * since in map[j] we count two elements sequence.
     * and also result we only add cj.
     *
     * Because cj is the number of sequence until index j. which include 2 elements sequence
     * when we append i to each of the sequence, the total number of sequence wont change
     * however the minimum number of elements will be 3 now,
     * now they become number of sequence until i which has at least 3 numbers.
     * so they are part of the result.
     * Basically we are acummulating result of all d in each i.
     */
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer, Integer>[] map = new Map[A.length];
        int result = 0;
        for(int i = 0; i < A.length; i++){
            map[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                long diff = (long)A[i] - A[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
                int d = (int)diff;

                int ci = map[i].getOrDefault(d,0);
                int cj = map[j].getOrDefault(d,0);
                result += cj;

                map[i].put(d,ci+cj+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {2,4,6,8,10};
        ArithmeticSlicesIISubsequence asiis = new ArithmeticSlicesIISubsequence();
        System.out.println(asiis.numberOfArithmeticSlices1(test));
    }
}

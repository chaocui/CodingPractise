package leetcode.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/5/31.
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        //Fastest and easiest way is to skip 0s.
        //But to understand the question. Implement using hash table.
        if(A == null || A.length == 0 || B == null || B.length == 0) return null;
        int r = A.length, cA = A[0].length, c = B[0].length;
        int[][] result = new int[r][c];
        //Only track B non-zeros.
        Map<Integer, HashMap<Integer, Integer>> tracker = new HashMap<>();
        for(int i = 0; i < cA; i++){
            tracker.put(i, new HashMap<>());
            for(int j = 0; j < c; j++){
                if(B[i][j] == 0) tracker.get(i).put(j, B[i][j]);
            }
        }

        //Start calculate only if number from A is not 0
        for(int i = 0; i < r; i++){
            for(int k = 0; k < cA; k++){
                //Basically A[i][k] contribute to all columns in row i to the final result
                //so get all non zero columns in row k in b.
                //A[i][j] += A[i][k]*B[k][j]
                if(A[i][k] != 0){
                    //here key is the index. so we get the key.
                    for(int j : tracker.get(k).keySet())
                        result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Integer i = null;
        System.out.println(2*i);
    }

}

package leetcode.medium;

/**
 * Created by cc on 2017/5/23.
 */
public class SparseMatrixMultiplication {

    //Skip when any of them is 0. reduce multiplication.
    //just a regular matrix multiplication. with check of 0s
    public int[][] multiply(int[][] A, int[][] B) {
        //row B = col A
        int rA = A.length, cA = A[0].length, cB = B[0].length;
        int[][] result = new int[rA][cB];
        for(int i = 0; i < rA; i++){
            for(int j = 0; j < cA; j++){
                if(A[i][j] != 0){
                    for(int m = 0; m < cB; m++){
                        if(B[j][m] != 0) result[i][m] += A[i][j]*B[j][m];
                    }
                }
            }
        }
        return result;
    }

}

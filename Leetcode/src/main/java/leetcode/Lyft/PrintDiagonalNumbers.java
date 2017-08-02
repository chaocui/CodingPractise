package leetcode.Lyft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/26.
 */
public class PrintDiagonalNumbers {

    public List<List<Integer>> solution(int[][] matrix){

        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;
        int r = matrix.length, c = matrix[0].length;
        for(int i = c-1; i >= 0; i--){
            int j = i;
            int row = 0;
            List<Integer> each = new ArrayList<>();
            while(j < c){
                each.add(matrix[row][j]);
                row = row + 1;
                j = j + 1;
            }
            result.add(each);
        }

        for(int i = 1; i < r; i++){
            int col = 0;
            List<Integer> each = new ArrayList<>();
            int j = i;
            while(j < r){
                each.add(matrix[j][col]);
                j = j + 1;
                col = col + 1;
            }
            result.add(each);
        }
        return result;
    }

    public static void main(String[] args) {
        PrintDiagonalNumbers pdn = new PrintDiagonalNumbers();
        int[][] test = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        List<List<Integer>> result = pdn.solution(test);
        for(List<Integer> l : result){
            for(int i : l){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

}

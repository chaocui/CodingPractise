package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/8.
 */
public class SpiralMatrix {

    /**
     * Strait forward solution.
     * 1. Since this is not a n*n matrix, cannot use row/column to traverse based on loops .
     * 2. Keep track of four edges. top, down, left, bottom.
     *    Same idea to print each edge, there is break condition.
     *    which is top > down || left > right, then we break.
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int r = matrix.length, c = matrix[0].length;
        int top = 0, down = r-1, left = 0, right = c-1;
        while(true){
            //up
            for(int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            //right
            for(int j = top + 1; j < down; j++)
                result.add(matrix[j][right]);
            /**
             * We do this special check because we print up and bottom as whole line.
             * not checking will result in dups.
             * */
            //if not the same line with up, we print.
            if(top != down) {
                //bottom
                for (int j = right; j >= left; j--)
                    result.add(matrix[down][j]);
            }
            //left
            if(left != right) {
                for (int j = down - 1; j > top; j--)
                    result.add(matrix[j][left]);
            }
            top++;down--;left++;right--;
            if(top > down || left > right) break;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {{1,2,3},{1,2,3},{1,2,3}};
        List<Integer> result = sm.spiralOrder(matrix);

        for(int i : result) System.out.print(i + ",");

    }

}

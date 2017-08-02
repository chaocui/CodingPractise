package leetcode.medium;

/**
 * Created by cc on 2017/3/21.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int index = n - 1;
        /**
         * Traverse level by level
         * */
        int i = 0;
        int num = 1;
        int[][] result = new int[n][n];
        while(i <= index/2){
            //upper border n elements
            for(int j = i; j <= index - i; j++){
                result[i][j] = num;
                num++;
            }
            //right border n - 1 elements
            for(int j = i+1; j <= index - i; j++){
                result[j][index-i] = num;
                num++;
            }
            //bottom border n - 1 elements
            for(int j = index - i - 1; j >= i; j--){
                result[index-i][j] = num;
                num++;
            }
            //left border n - 2 elements
            for(int j = index - i - 1; j >= i+1; j--){
                result[j][i] = num;
                num++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII sm = new SpiralMatrixII();
        int[][] result = sm.generateMatrix(4);
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

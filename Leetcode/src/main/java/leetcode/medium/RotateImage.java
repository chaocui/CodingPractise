package leetcode.medium;

/**
 * Created by cc on 2017/3/21.
 */
public class RotateImage {

    /**
     * Important part is to get the index of each rotate position based on the starting position.
     * */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int index = length - 1;
        int i = 0;
        //loop from the out most square, until the center.
        while(i <= index/2){
            //for each square
            //start is i, end is index - i. since both sides needs to be go one level inside.
            for(int j = i; j < index - i; j++){
                int topLeft = matrix[i][j];
                int topRight = matrix[j][index - i];
                int bottomRight = matrix[index-i][index-j];
                int bottomLeft = matrix[index - j][i];
                matrix[j][index - i] = topLeft;
                matrix[index-i][index-j] = topRight;
                matrix[index - j][i] = bottomRight;
                matrix[i][j] = bottomLeft;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int num = 1;
        for(int i =1; i <= matrix.length; i ++){
            for(int j = 1; j <= matrix.length; j++){
                matrix[i-1][j-1] = num;
                num++;
            }
        }
        RotateImage ri = new RotateImage();
        ri.rotate(matrix);
        for(int i =1; i <= matrix.length; i ++){
            for(int j = 1; j <= matrix.length; j++){
                System.out.print(matrix[i-1][j-1] + " ");
            }
            System.out.println();
        }
    }

}

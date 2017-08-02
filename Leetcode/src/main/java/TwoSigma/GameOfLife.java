package TwoSigma;

/**
 * Created by cc on 2016/8/14.
 */
public class GameOfLife {
    //inplace solution
    //0 -> 0    status 0
    //0 -> 1    status 3
    //1 -> 0    status 2
    //1 -> 1    status 1
    //So 1, 2 means previous state is alive
    //0,3 means previous state is dead
    public void solution(int[][] matrix){

        //Since there are 8 conditions needs to be checked.
        //Instead of checking them 1 by 1.
        //Put them in array, use a for loop. reduce code.
        int x[] = {-1,-1,-1,0,0,1,1,1};
        int y[] = {-1,0,1,-1,1,-1,0,1};

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                //Count number of alives in 8 neighbours.
                int count = 0;
                for(int m = 0; m < 8; m ++){
                    int pX = i + x[m];
                    int pY = j + y[m];
                    if(pX >= 0 && pX < matrix.length && pY >= 0 && pY < matrix[0].length && (matrix[pX][pY] == 1 || matrix[pX][pY] == 2)){
                        count++;
                    }
                }
                if((count < 2 || count > 3) && matrix[i][j] == 1){
                    matrix[i][j] = 2;
                }
                else if(count == 3 && matrix[i][j] == 0){
                    matrix[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j]%2;
            }
        }
    }
}

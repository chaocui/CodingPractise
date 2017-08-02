package TwoSigma.QuestionSet2;

/**
 * Created by cc on 2016/8/27.
 *
 * live < 2  --  1->0 status 2
 * live == 2 || 3 -- 1->1 status 1
 * live > 3 -- 1->0 status 2
 * live == 3  -- 0->1 status 3
 * otherwise 0->0 status 0
 */
public class GameOfLife2D {

    public void gameOfLife(int[][] life){

        int m = life.length;
        int n = life[0].length;

        int[] xShift = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yShift = {-1, 0, 1, -1, 1, -1, 0, 1};


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveCount = 0;
                for(int p = 0; p < 8; p++){

                    int px = i + xShift[p];
                    int py = j + yShift[p];

                    if(px >=0 && px < m && py >=0 && py < n && (life[px][py] == 1 || life[px][py] == 2)){
                        liveCount++;
                    }

                    if(liveCount == 3 && life[i][j] == 0){
                        life[i][j] = 3;
                    }
                    if((liveCount < 2 || liveCount > 3) && life[i][j] == 1){
                        life[i][j] = 2;
                    }
                    //Otherwise stay the same
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                life[i][j] = life[i][j]%2;
            }
        }
    }
}

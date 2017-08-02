package leetcode.hard;

/**
 * Created by cc on 2017/5/27.
 */
public class PaintHouseII {

    /**
     * basically the same idea of PaintHouse,
     * DP
     * Keep track of min1 and min2 index of previous house paint.
     * costs[][] keep track of for house r, color c, the minimum cost.
     *
     * return the last row min1
     * */
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int r = costs.length, c = costs[0].length;
        int min1 = -1, min2 = -1;
        for(int i = 0; i < r; i++){
            //use last1 and last2 keep track of last row min1 and min2.
            //updating min1 and min2 in this inner loop.
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;
            for(int j = 0; j < c; j++){
                //if current index is last1, so we need to use second last one to make this minimum.
                if(j == last1) costs[i][j] += last2 < 0 ? 0 : costs[i-1][last2];
                //otherwise, we use the previous minimum
                else costs[i][j] += last1 < 0 ? 0 : costs[i-1][last1];

                //Then we update min1 and min2 in this loop.
                //min1 and min2 initialized as -1 for every loop.
                //so first number will update min1 to index j, and min2 to -1 still.
                //if second number is smaller than min1, update min2 to min1, min1 to current.
                //otherwise, go to else if, update min2 to current.
                //then min1 and min2 are not < 0 any more, so the normal condition.
                //if less than min1, update min2 = min1, min1 = current.
                //else if < min2, means > min1 && < min2, update min2 only.
                if(min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1; min1 = j;
                }
                else if(min2 < 0 || costs[i][j] < costs[i][min2])
                    min2 = j;
            }
        }
        return costs[r-1][min1];
    }

}

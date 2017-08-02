package leetcode.Linkedin;

/**
 * Created by cc on 2017/7/28.
 */
public class PaintHouse {
    /**
     * Basic idea is use costs to track paint first n house, least cost
     * Initially, paint the first 1 house,
     * minimum cost of each color is costs[0][0-2]
     * */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        for(int i = 1; i < costs.length; i++){
            //paint this house use red, either paint previous blue or green
            //same idea for other colors
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        //return paint the first n houst, which color costs minimum.
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}

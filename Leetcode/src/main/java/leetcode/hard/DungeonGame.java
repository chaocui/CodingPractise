package leetcode.hard;

/**
 * Created by cc on 2016/11/2.
 */
public class DungeonGame {
    //Key point is starting from bottom right.
    //DP contains : from each cell, the minimum health.
    //Knight has to have at least one health at any cell.
    //the next step health will be currentHealth + dungeon[][] = nextHealth.
    //So dp function
    //dp[i][j] = Math.min(fromRight, fromDown);
    //fromRight = dp[i][j+1] - dungeon[i][j]
    //fromDown = dp[j+1][j] - dungeon[i][j]
    //If they are less then or equal to 0,(means reach this cell, needs negtive health, which is impossible, at least 1) then set health to 1;
    //Starting from bottom right
    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int dp[][] = new int[rows][cols];

        int bottomRightHealth = 1-dungeon[rows-1][cols-1];
        dp[rows-1][cols-1] = bottomRightHealth <= 0 ? 1 : bottomRightHealth;

        //last row, only from right
        for(int j = cols - 2; j >= 0; j--){
            int health = dp[rows-1][j+1] - dungeon[rows-1][j];
            if(health <= 0){
                health = 1;
            }
            dp[rows-1][j] = health;
        }

        //last col, only from down
        for(int i = rows - 2; i >= 0; i--){
            int health = dp[i+1][cols-1] - dungeon[i][cols-1];
            if(health <= 0){
                health = 1;
            }
            dp[i][cols-1] = health;
        }

        //Rest
        for(int i = rows-2; i >= 0; i--){
            for(int j = cols-2; j >= 0; j--){

                int healthFromRight = dp[i][j+1] - dungeon[i][j];
                if(healthFromRight <= 0){
                    healthFromRight = 1;
                }

                int healthFromDown = dp[i+1][j] - dungeon[i][j];
                if(healthFromDown <= 0){
                    healthFromDown = 1;
                }
                dp[i][j] = Math.min(healthFromDown, healthFromRight);
            }
        }

        return dp[0][0];
    }
}

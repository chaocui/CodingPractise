package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cc on 2017/4/30.
 */
public class TheMaze {

/**
 * Basic idea is
 * we define 4 directions, do a while loop when it stops on each direction.
 * If the stopping point is the target, we return true.
 * If the stopping point is already stopped before, we just ignore it.
 * If not, we recursively do for directions.
 *
 * If not return in previous code.
 * We mark the stopping point
 * */
    public boolean solution(int[][] matrix, int[] start, int[] end){
        if(matrix == null || matrix.length == 0) return true;
        int[][] df = new int[matrix.length][matrix[0].length];
        int[][] visited = new int[matrix.length][matrix[0].length];
        Arrays.fill(df,-1);
        return dfs(start[0],start[1], matrix, end, df, visited);
    }

    public boolean dfs(int x, int y, int[][] matrix, int[] end, int[][] df, int[][] visited){
        if(x == end[0] && y == end[1]) return true;
        if(df[x][y] != -1) return df[x][y] == 1;
        visited[x][y] = -1;
        int[][] d = {{0,1},{0,-1},{-1,0},{1,0}};
        boolean result = false;
        for(int i = 0; i < 4; i++){
            int x1 = x, y1 = y;
            //until it hits the boarder, just keep going.
            while(x1 >= 0 && x1 < matrix.length && y1 >=0 && y1 < matrix[0].length && matrix[x1][y1] != 1){
                x1 = x1 + d[i][0];
                y1 = y1 + d[i][1];
            }
            //when hits the boarder, move one step back which is the position in the maze.
            x1 = x1 - d[i][0];
            y1 = y1 - d[i][1];

            //-1 means visited.
            //if not visited, just recursively call dfs.
            //result || dfs result. Because we only need one direction to hit the target to, then result is true.
            //So we use || operator.
            if(visited[x1][y1] != -1){
                result = result || dfs(x1,y1,matrix,end,df,visited);
            }
        }
        visited[x][y] = 0;
        df[x][y] = result ? 1:0;
        return result;
    }
}

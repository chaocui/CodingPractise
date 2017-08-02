package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2017/3/8.
 */
public class NumberOfIslands {
    int[][] moves = {{0,-1},{0,1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    mark(grid, new int[]{i,j});
                    result++;
                }
            }
        }
        return result;
    }

    //recursive dfs, why pass? why iteration dfs cannot.???
    //recursively mark all 1s to #
    private void mark(char[][] grid, int[] start){
        grid[start[0]][start[1]] = '#';
        for(int i = 0; i < moves.length; i++){
            int x = start[0] + moves[i][0];
            int y = start[1] + moves[i][1];
            //if its 0, not part of island, if its # means it has been visited
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1')
                mark(grid,new int[]{x,y});
        }
    }
    //once dfs done,
    private void dfs(char[][] grid, int[] start){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            grid[p[0]][p[1]] = '#';
            for(int i = 0; i < moves.length; i++){
                int x = p[0] + moves[i][0];
                int y = p[1] + moves[i][1];
                //if its 0, not part of island, if its # means it has been visited
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1')
                    queue.offer(new int[]{x,y});
            }
        }
    }

}

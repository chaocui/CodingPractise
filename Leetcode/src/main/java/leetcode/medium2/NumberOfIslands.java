package leetcode.medium2;

/**
 * Created by cc on 2017/4/29.
 */
public class NumberOfIslands {

    /**
     * Basic idea.
     * Recursive
     * For each cell, if it is still one. then we bfs to fill out all adjacent 1s.
     * Once recursion done for current point. means this is one island.
     * We increase result by 1.
     * */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    markVisited(i,j,grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void markVisited(int i, int j, char[][] grid){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '#' || grid[i][j] == '0')
            return;
        grid[i][j] = '#';
        markVisited(i-1,j,grid);
        markVisited(i+1,j,grid);
        markVisited(i,j-1,grid);
        markVisited(i,j+1,grid);
    }
}

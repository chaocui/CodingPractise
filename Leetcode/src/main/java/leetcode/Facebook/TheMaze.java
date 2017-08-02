package leetcode.Facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2017/6/4.
 */
public class TheMaze {

    /***
     * BFS,
     * keep track of which position has been visited.
     * for loop to roll four directions.
     * once stop check if this is the dest or if this has been visited.
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        int r = maze.length, c = maze[0].length;
        int[][] visited = new int[r][c];
        Queue<int[]> queue =  new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = 1;
        int[][] d = {{0,-1},{0,1},{-1,0},{1,0}};
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int i = 0; i < 4; i++){
                int[] dir = d[i];
                int m = p[0], n = p[1];
                while(m >= 0 && m <= r - 1 && n >= 0 && n <= c-1 && maze[m][n] != 1){
                    m += dir[0];
                    n += dir[1];
                }
                //move one position back, that the final position of this direction.
                m = m - dir[0];
                n = n - dir[1];

                /**
                 * Check if hit destination, if yes, return true;
                 * otherwise, check visited or not, if not, put in queue.
                 * */
                if(m == destination[0] && n == destination[1]) return true;
                if(visited[m][n] != 1) {
                    visited[m][n] = 1;
                    queue.offer(new int[]{m, n});
                }
            }
        }
        return false;
    }


}

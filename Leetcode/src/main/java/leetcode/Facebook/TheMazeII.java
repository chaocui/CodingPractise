package leetcode.Facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2017/6/4.
 */
public class TheMazeII {

    /**
     * Instead of check if can reach destination, now check the minimum steps we need.
     * DP
     * basically same idea,
     * visited matrix just track the minimum steps to each position.
     * if new value to this position is smaller or not visited before, add to queue. otherwise skip.
     * */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return -1;
        int r = maze.length, c = maze[0].length;
        int[][] visited = new int[r][c];
        for(int[] a : visited) Arrays.fill(a, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int i = 0; i < 4; i++){
                int[] d = dir[i];
                int m = p[0], n = p[1];
                int steps = 0;
                while(m >= 0 && m < r && n >= 0 && n < c && maze[m][n] != 1){
                    m += d[0];
                    n += d[1];
                    steps++;
                }
                m = m - d[0];
                n = n - d[1];
                steps--;
                steps = steps + visited[p[0]][p[1]];
                if(steps < visited[m][n]){
                    visited[m][n] = steps;
                    queue.offer(new int[]{m, n});
                }
            }
        }
        return visited[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : visited[destination[0]][destination[1]];
    }
}

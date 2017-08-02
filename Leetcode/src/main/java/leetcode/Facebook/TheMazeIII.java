package leetcode.Facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2017/6/4.
 */
public class TheMazeIII {

    /**
     * Basically same idea.
     * Different part is the update criteria and loop.
     * Loop stop need add one more hole position check.
     * once stop,
     * 1. if it is hole, compare steps, if steps smaller, update steps and route,
     *    if equal, compare path, update path to smaller one.
     * 2. if it is not hole,
     *    back to the stop position
     *    do the same comparison.
     * */
    public class Pojo{
        int l;
        String path;
        public Pojo(int l, String p){
            this.l = l;
            this.path = p;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int r = maze.length, c = maze[0].length;
        Pojo[][] visited = new Pojo[r][c];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        char[] dc = {'u','d','l','r'};
        visited[ball[0]][ball[1]] = new Pojo(0, "");
        queue.offer(ball);
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int i = 0; i < 4; i++){
                int[] d = dir[i];
                int m = p[0], n = p[1];
                boolean drop = false;
                int steps = visited[p[0]][p[1]].l;
                StringBuilder sb = new StringBuilder(visited[p[0]][p[1]].path);
                while(m >= 0 && m < r && n >= 0 && n < c && maze[m][n] != 1){
                    if(m == hole[0] && n == hole[1]){
                        drop = true;
                        break;
                    }
                    m += d[0];
                    n += d[1];
                    steps ++;
                }
                //if not drop, move one step back.

                if(!drop) {
                    m -= d[0];
                    n -= d[1];
                    steps--;
                }
                //only append steps if we moved more than 1.
                if(steps > 0) sb.append(dc[i]);
                /**
                 * Three conditions that we update
                 * 1. never visited before.
                 * 2. new route shorter.
                 * 3. route length same, but new route string is smaller.
                 *
                 * only offer to queue if not hit the hole.
                 * */
                if(visited[m][n] == null || visited[m][n].l > steps ||
                        (visited[m][n].l == steps && visited[m][n].path.compareTo(sb.toString()) > 0)) {
                    visited[m][n] = new Pojo(steps, sb.toString());
                    if(!drop) queue.offer(new int[]{m,n});
                }
            }
        }
        return visited[hole[0]][hole[1]] == null ? "" : visited[hole[0]][hole[1]].path;
    }
}

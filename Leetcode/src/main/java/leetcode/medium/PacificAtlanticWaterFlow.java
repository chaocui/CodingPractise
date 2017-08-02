package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cc on 2017/3/7.
 */
public class PacificAtlanticWaterFlow {
    //Use boolean matrix is faster than int matrix??????????
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        Queue<int[]> pacific = new LinkedList<int[]>();
        Queue<int[]> atlantic = new LinkedList<int[]>();
        int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int row = matrix.length, col = matrix[0].length;
        int[][] pVisited = new int[row][col];
        int[][] aVisited = new int[row][col];
        //put the borders of pacific and atlantic to queue.
        //mark the positions visited in the corresponding visited array.
        for(int i = 0; i < row; i++) {
            pacific.offer(new int[]{i, 0});
            atlantic.offer(new int[]{i,col-1});
        }
        for(int i = 0; i < col; i++) {
            pacific.offer(new int[]{0, i});
            atlantic.offer(new int[]{row-1,i});
        }

        bfs(pacific,pVisited,moves,matrix);
        bfs(atlantic,aVisited,moves,matrix);

        //if a position is visited in both of the matrix.
        //which means that this position can go to both order.
        //we add it to result
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pVisited[i][j] == 1 && aVisited[i][j] == 1)
                    result.add(new int[]{i,j});
            }
        }
        return result;
    }

    private void bfs(Queue<int[]> queue, int[][] visited, int[][] moves, int[][] matrix){
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            //mark current position visited.
            visited[position[0]][position[1]] = 1;
            //Move to four direction, we need to add the position which has value >= current to queue.
            //So that the water from here can flow to the border
            for(int i = 0; i < moves.length; i++){
                int x = position[0] + moves[i][0];
                int y = position[1] + moves[i][1];
                //if went out of border or current is greater than destination we skip
                if(x < 0 || x >= visited.length || y < 0 || y >= visited[0].length || matrix[x][y] < matrix[position[0]][position[1]])
                    continue;
                queue.offer(new int[]{x,y});
            }
        }
    }

}

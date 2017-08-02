package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2017/5/26.
 */
public class WallsAndGates {

    /**
     *  Put all 0 points(gates) into queue.
     *  for each points in the queue,
     *  updating up, down, left, right only if it is not updated.
     *  which means,
     *  1. If its empty room and it is not out of bound.
     *
     *  This can make sure this is minimum distance,
     *  because we will update only if it is still empty room, means that
     *  if it is already updated, it has shorter path to gate. we dont update it again.
     * */
    public void wallsAndGates(int[][] rooms) {

        if(rooms == null || rooms.length == 0) return;

        int r = rooms.length, c = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(rooms[i][j] == 0) queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            if(x > 0 && rooms[x-1][y] == Integer.MAX_VALUE){
                rooms[x-1][y] = rooms[x][y]+1;
                queue.add(new int[]{x-1,y});
            }
            if(x < r - 1 && rooms[x+1][y] == Integer.MAX_VALUE){
                rooms[x+1][y] = rooms[x][y]+1;
                queue.add(new int[]{x+1,y});
            }
            if(y > 0 && rooms[x][y-1] == Integer.MAX_VALUE){
                rooms[x][y-1] = rooms[x][y]+1;
                queue.add(new int[]{x,y-1});
            }
            if(y < c - 1 && rooms[x][y+1] == Integer.MAX_VALUE){
                rooms[x][y+1] = rooms[x][y]+1;
                queue.add(new int[]{x,y+1});
            }
        }
    }
}

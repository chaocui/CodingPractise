package leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cc on 2017/4/7.
 */
public class ZeroOneMatrix {

    /**
     * Initialize all non-zero values to be Integer.Max
     * put all zeros into queue.
     * then we start until queue is empty.
     * for each 0, we assign the adjacent cells. If the new value is less then current, assign it. otherwise skip.
     * if we assign the adjacent, we put the adjacent cell into queue also.
     * */
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j) == 0){
                    queue.offer(new int[]{i,j});
                }
                else{
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }

        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int i = 0; i < d.length; i++){
                int r = p[0] + d[i][0];
                int c = p[1] + d[i][1];
                //if out of bound or new value is greater than or equal to existing.
                if(r < 0 || r >= matrix.size() || c < 0 || c >= matrix.get(0).size() || matrix.get(r).get(c) <= matrix.get(p[0]).get(p[1])+1) continue;
                matrix.get(r).set(c,matrix.get(p[0]).get(p[1])+1);
                queue.offer(new int[]{r,c});
            }
        }
        return matrix;
    }
}

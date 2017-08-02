package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cc on 2017/4/9.
 */
public class FriendCircles {

    //DFS
    public static int findCircleNum(int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> inCircle = new HashSet<Integer>();
        int result = 0;
        //If the current person is not in circle, we check the current circle.
        //if it is already in circle, we skip it.
        //otherwise, we just continue;
        for(int i = 0; i < M.length; i++){
            if(inCircle.add(i))
                queue.offer(i);
            else
                continue;
            //DFS starting from current person.
            //find all the related person, once queue is empty, means current circle done.
            while(!queue.isEmpty()){
                int p = queue.poll();
                for(int j = 0; j < M[p].length; j++){
                    if(M[p][j] == 1 && inCircle.add(j)){
                        queue.offer(j);
                    }
                }
            }
            result ++;
        }
        return result;
    }

}

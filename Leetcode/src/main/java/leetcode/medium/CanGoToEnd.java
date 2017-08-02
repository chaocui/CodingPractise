package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cc on 2017/4/30.
 */
public class CanGoToEnd {

    //array of 0 and 1,
    //you can go 1, -1, n(parameter) every time.
    //if you can reach the end of array.
    //Just bfs.
    //Use a set to track where visited.
    public boolean solution(int n , int[] array){
        if(array[0] == 0) return false;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] steps = {1,-1,n};
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i : steps){
                int newP = p+i;
                if(p+i >= array.length) return true;
                if(p+i == array.length - 1 && p + i == 1) return true;
                if(p+i <= 0)
                    continue;
                else if(array[p+i] == 1 && !visited.contains(array[p+i])){
                    q.offer(p+i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanGoToEnd cgte = new CanGoToEnd();
    }

}

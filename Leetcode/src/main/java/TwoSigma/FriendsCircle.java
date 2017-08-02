package TwoSigma;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cc on 2016/7/26.
 */
public class FriendsCircle {

    public int circleCount(String[][] m){

        if(m.length == 0 || m == null){
            return 0;
        }

        Set<Integer> track = new HashSet<Integer>();
        int result = 0;
        for(int i = 0; i < m.length; i++){
            //If student is already in track, means he is already in some circle, so ignore it.
            if(!track.contains(i)){
                track.add(i);
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                //When queue is empty, means this circle finished process
                while(!queue.isEmpty()){
                    Integer student = queue.poll();
                    for(int j = 0; j < m.length; j++){
                        if(m[student][j] == "y" && !track.contains(j)){
                            queue.offer(j);
                            track.add(j);
                        }
                    }
                }
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String test[][] = new String[][]{
            {"y","n","y","y","n"},
            {"n","y","y","n","n"},
            {"y","y","y","n","n"},
            {"y","n","n","y","n"},
            {"n","n","n","n","n"}
        };
        FriendsCircle fc = new FriendsCircle();
        System.out.println(fc.circleCount(test));
    }
}

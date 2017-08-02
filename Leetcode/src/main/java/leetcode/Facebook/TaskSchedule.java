package leetcode.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/6/5.
 */
public class TaskSchedule {

    /**
     * First version is cannot change sequence. calculate the run time.
     * Basically the same as the adding bridge.
     * Use hash map track start time of previous same task,
     * if less than cool down, then we cool down, if not we start this new task.
     * */
    public int solution(int[] tasks, int cd){
        Map<Integer, Integer> tracker = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int currentPosition = 0;
        for(int i : tasks){
            if(!tracker.containsKey(i) || currentPosition - tracker.get(i) - 1 >= cd){
                sb.append(i);
                currentPosition ++;
            }
            else{
                int wait = currentPosition - tracker.get(i) - 1;
                for(int j = 0; j < wait; j++){
                    sb.append("_");
                    currentPosition ++;
                }
                sb.append(i);
                currentPosition++;
            }
        }
        return sb.length();
    }

}

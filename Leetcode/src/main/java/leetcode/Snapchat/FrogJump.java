package leetcode.Snapchat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/6/16.
 */
public class FrogJump {

    /**
     *  Use a map to track current rock and the steps can jump from current rock.
     *
     *  Basically, initially, rock 0 can jump 1.
     *  all other rocks are empty.
     *  Then loop through all rocks.
     *  for each rock, see where it can go.
     *  if the place is in map, then based on current step, we add the possible jump steps to that map.
     * */
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> jumps = new HashMap<>();
        //add all stones to map, and initialize the set of steps.
        for(int i = 0; i < stones.length; i++){
            int stone = stones[i];
            jumps.put(stone, new HashSet<Integer>());
        }
        //put step in first stone, you can only jump 1.
        jumps.get(0).add(1);

        //loop through all stones.
        for(int i = 0; i < stones.length; i++){
            int stone = stones[i];
            Set<Integer> steps = jumps.get(stone);
            //for each stone, see the possible steps you can jump
            for(int step : steps){
                int reach = stone + step;
                //if after jump, reach the end, return true;
                if(reach == stones[stones.length - 1]) return true;
                //check if reach stone is in original list.
                if(jumps.containsKey(reach)){
                    //if in, we add possible jumps which is current step - 1, step, step + 1 to its jump set.
                    jumps.get(reach).add(step);
                    jumps.get(reach).add(step+1);
                    if(step - 1 > 0) jumps.get(reach).add(step - 1);
                }
            }
        }
        //if reach the end still not return true, it is impossible.
        return false;
    }
}

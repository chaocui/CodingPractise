package leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/5/27.
 */
public class BrickWall {

    /**
     * Basic idea
     * For each row, from start to each ending edge. calculate the length.
     * Use hash map keep track the count of each length in all rows.
     * loop through the map, find maximum count.
     * cross = row - max count.
     * */
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(List<Integer> l : wall){
            int sum = 0;
            //since left and right boarder always has 0 cross, we ignore them.
            //ignore the last brick on every row.
            for(int i = 0; i < l.size() - 1; i++){
                sum += l.get(i);
                count.put(sum, count.getOrDefault(sum,0)+1);
            }
        }

        for(Map.Entry<Integer, Integer> each : count.entrySet()){
            max = Math.max(max, each.getValue());
        }
        return wall.size() - max;
    }
}

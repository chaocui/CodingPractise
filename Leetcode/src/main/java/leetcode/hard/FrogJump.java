package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2016/11/22.
 */
public class FrogJump {

    //LTE
    public boolean canCross(int[] stones) {
        return jump(0,0,stones);
    }

    public boolean jump(int currentPosition, int lastJump, int[] stones){
        //If reach, return true;
        if(currentPosition == stones.length - 1){
            return true;
        }
        //otherwise, recursive
        int steps[] = {-1,0,1};
        for(int i = 0; i < 3; i++){
            int nextStep = lastJump + steps[i];
            int nextDest = stones[currentPosition] + nextStep;
            int nextPosition = Arrays.binarySearch(stones,currentPosition+1,stones.length,nextDest);
            if(nextPosition > 0){
                if(jump(nextPosition,nextStep,stones)) return true;
            }
        }
        return false;
    }
}

package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/2/15.
 */
public class CanIWin {

    Map<Integer, Boolean> track = new HashMap<Integer, Boolean>();
    boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        //if total sum is less than target, can never win
        if(sum < desiredTotal) return false;
        //if desiredTotal <=0, will always win.
        if(desiredTotal <= 0) return true;
        used = new boolean[maxChoosableInteger+1];
        return win(desiredTotal);
    }

    private boolean win(int desiredTotal){
        //why the base condition is return false;
        if(desiredTotal <= 0) return false;
        int key = convertToInteger(used);
        //If not contains current key, we calculate.
        if(!track.containsKey(key)){
            for(int i = 1; i < used.length; i++){
                if(!used[i]){
                    used[i] = true;
                    //this win(desiredTotal - i) means that
                    //if we take i, and we can win
                    if(!win(desiredTotal - i)){
                        //so starting point is key(which i is not used)
                        //we take i, we can win. so we put key true.
                        track.put(key,true);
                        //then we mark i as not used.
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            //if we not returning in loop, means that cannot win at this key point.
            track.put(key, false);
        }
        //otherwise, we use directly.
        return track.get(key);
    }

    private int convertToInteger(boolean[] used){
        int result = 0;
        for(boolean b : used){
            result = result << 1;
            if(b) result = result | 1;
        }
        return result;
    }

}

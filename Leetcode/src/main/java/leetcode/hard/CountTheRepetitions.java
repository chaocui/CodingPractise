package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/4/13.
 */
public class CountTheRepetitions {

    /**
     * Why these people can come up with the solution.
     * What's in those people's brain,
     * 16 core 64 threads 128 RAM 5000 Hz GPU/CPU??????
     * There is no way i can get this solution
     * even i spend a week on this question!!!!!!!!!!!!!!!!!!!!
     * Even costs me 1.5 hours to understand the solution, plus coding,
     * that will be 2 hours!!!!
     * 明确自我认知...    :( sad...
     *
     *
     *
     * */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(!ableToGet(s1,s2)) return 0;
        String s = s1;
        int count = 0, loopStartIndex = -1;
        List<String> remaining = new ArrayList<>();
        List<Integer> countL = new ArrayList<>();
        remaining.add("");
        countL.add(0);
        StringBuilder remain;
        for(int i = 1; i <= n1; i++){
            remain = new StringBuilder();
            count += getRemaining(s,s2,remain);
            String r = remain.toString();
            //if the remaining showed up before, means we are running into a loop, no need to recalculate again.
            //just use math to get result based on the loop
            if((loopStartIndex = remaining.indexOf(r)) != -1) break;
            remaining.add(r);
            countL.add(count);
            //append another s to remaining and keep calculating
            s = r + s1;
        }
        //if there is no loop, just return.
        if(loopStartIndex == -1) return count/n2;
        //if there is loop, we need to do math.
        int eachLoopCount = count - countL.get(loopStartIndex);
        //each loop use how many s1.
        int loopInterval = countL.size() - loopStartIndex;
        //remove the first loopStartIndex, only count loop ones
        n1 = n1 - loopStartIndex;
        //plus the first loopStartIndex count.
        count = countL.get(loopStartIndex) + eachLoopCount*(n1/loopInterval);
        /**
         * This part is because
         * lets say loop interval is 4, loopStartIndex is 1
         *
         * so lets say 15 s1.
         * 0 1-4 5-8 9-12 13 14
         * (15 - 1)%4 = 2
         * which is 13-14 not count.
         * which is equivalent to 2-3.
         * so countL.get(loopStartIndex + n1%loopInterval) - countL.get(loopStartIndex)
         * which gives k+1 to k+1+n1%loopInterval count
         */
        count = count + countL.get(loopStartIndex + n1%loopInterval) - countL.get(loopStartIndex);
        return count/n2;
    }
    //Assume we have infinite s1, can we get s2.
    private boolean ableToGet(String s1, String s2){
        boolean[] map = new boolean[26];
        for(char c : s1.toCharArray()) map[c-'a'] = true;
        for(char c : s2.toCharArray()) {
            if (!map[c - 'a']) return false;
        }
        return true;
    }
    //used to get
    //1. count of s2 in s1,
    //2. whats left after getting s2. store in sb.
    private int getRemaining(String s1, String s2, StringBuilder sb){
        int count = 0, is2 = 0, remainingStart = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(is2)){
                is2++;
                //found match of s2 in s1, reset s2 index.
                if(is2 == s2.length()){
                    is2 = 0;
                    count++;
                    remainingStart = i+1;
                }
            }
        }
        sb.append(s1.substring(remainingStart));
        return count;
    }
}

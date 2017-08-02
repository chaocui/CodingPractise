package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by cc on 2017/3/11.
 */
public class BullsAndCows {
    //One pass solution
    //Basic idea,
    //count bull immediately.
    //for cow, use one arrays to track each number in secret and guess.
    //if in secret, count++, if in guess, count --;
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length(); i++){
            char sC = secret.charAt(i);
            char gC = guess.charAt(i);
            if(sC == gC){
                bull++;
                continue;
            }
            //check if char in secret showed up in guess before, if yes, cow ++;
            //Reason is that if current count < 0, means that it was substract because of showing up in guess.
            //Since show up in guess, will reduce count.
            if(count[sC-'0'] < 0) cow ++;
            //check if char in guess showed up in secret before, if yes, cow ++;
            //same reason as above.
            if(count[gC-'0'] > 0) cow ++;
            count[sC-'0']++;
            count[gC-'0']--;
        }
        return bull+"A"+cow+"B";
    }

    //Two pass which is slower
    public String getHintII(String secret, String guess) {
        Set<Integer> bullPosition = new HashSet<Integer>();
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int bullCount = 0, cowCount = 0;
        for(int i = 0; i < secret.length(); i++){
            if(count.containsKey(secret.charAt(i))){
                count.put(secret.charAt(i), count.get(secret.charAt(i))+1);
            }
            else{
                count.put(secret.charAt(i),1);
            }
            if(secret.charAt(i) == guess.charAt(i)){
                bullCount++;
                bullPosition.add(i);
                count.put(secret.charAt(i),count.get(secret.charAt(i))-1);
            }
        }

        for(int i = 0; i < guess.length(); i++){
            if(bullPosition.contains(i)) continue;
            if(count.get(guess.charAt(i))!=null && count.get(guess.charAt(i)) > 0){
                cowCount++;
                count.put(guess.charAt(i),count.get(guess.charAt(i))-1);
            }
        }
        return bullCount+"A"+cowCount+"B";
    }
}

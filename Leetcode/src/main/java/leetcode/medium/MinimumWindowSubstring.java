package leetcode.medium;

/**
 * Created by cc on 2017/3/10.
 */
public class MinimumWindowSubstring {

    //Basic idea, sliding window.
    //1.set counter of substring, how many chars, how many each chars.
    //2.set start, end.
    //3.update end based on condition. Condition of this issue is char in S.
    //4.once counter reach 0. we start update start until count is not 0.
    //until end reach the end of S.

    /**
     * Basically,
     * Only chars in t has a chance to have counter = 0 and change the count.
     * the reason is all the chars initialized as counter > 0.
     * All others are initialized as 0.
     *
     * end will move first, all chars not int t will become negtive.
     * when we move start, these chars all have negtive when we check, so wont increase count.
     * when we increase the count of these chars we already pass them. So they wont matter any more.
     *
     * only the chars in t will have count = 0 then we increase the count.
     * */

    public String minWindow(String s, String t) {
        int[] counter = new int[128];
        for(char c : t.toCharArray()) counter[c]++;
        int count = t.length();
        int start = 0, end = 0, length = Integer.MAX_VALUE,head = 0;
        while(end < s.length()){
            char currentC = s.charAt(end);
            //If this char still have in substring. reduce count.
            if(counter[currentC] > 0)
                count--;
            //we need to decrease counter of each char.
            //The reason is for example

            //ADOBECODEBANC
            //once we reach the first C, we move start to D. then during the process move end to next A.
            //we substract B again, make it -1.
            //means that we can ignore the first B we met when we move start.
            //So when we move start, first B is -1. so we keep moving.
            //then we reach C, which is 0, then new start is at O.
            //then we move end to C,
            //then we move start, O D are -1 since when end go pass them, the got substract.
            //until we reach B. which is 0. then we move end again.

            //increase end any way.
            counter[currentC] --;
            end++;
            while(count == 0){
                char currentS = s.charAt(start);

                if(length > end - start){
                    length = end - start;
                    head = start;
                }
                if(counter[currentS] == 0)
                    count ++;
                counter[currentS] ++;
                start ++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(head, head+length);
    }

    public static void main(String[] args){

        String S = "ADOBECODEBANC";
        String T = "ABCB";

        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow(S,T));
    }
}

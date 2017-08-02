package leetcode.hard;

/**
 * Created by cc on 2017/4/18.
 */
public class ZumaGame {
    int max = 6;
    public int findMinStep(String board, String hand) {
        //Count the balls we have.
        int[] h = new int[26];
        for(char c : hand.toCharArray()) h[c-'A']++;
        int result = helper(board+"#", h);
        return result == max ? -1:result;
    }

    public int helper(String s, int[] h){
        int result = max;
        s = removeConsecutive(s);
        //we need to construct a base case which return 0. which is we dont need to remove.
        if(s.equals("#")) return 0;
        //so after remove consecutive,
        //we have at most 2 consecutive chars.
        for(int i = 0, j = 0; j < s.length(); j++){
            if(s.charAt(i) == s.charAt(j)) continue;
            //j - i is consecutive numbers, 3 - (j - i) is the number of chars we need.
            int needed = 3 - (j - i);
            if(h[s.charAt(i) - 'A'] >= needed){
                h[s.charAt(i) - 'A'] -= needed;
                result = Math.min(result, needed + helper(s.substring(0,i)+s.substring(j), h));
                h[s.charAt(i) - 'A'] += needed;
            }
            //same thing as remove consecutive, after we process current i, we move i to the next position
            //which is j who does not equal to i.
            i=j;
        }
        return result;
    }

    //This is key part of this question.
    //how to recursively remove consecutive
    public String removeConsecutive(String s){
        for(int i = 0, j = 0; j < s.length(); j++){
            if(s.charAt(i) == s.charAt(j)) continue;
            if(j - i >= 3)
                return removeConsecutive(s.substring(0,i) + s.substring(j));
            else
                i = j;
        }
        return s;
    }

    public static void main(String[] args) {
        ZumaGame zg = new ZumaGame();
        System.out.println(zg.removeConsecutive("ecaabbbaaccd"));
    }
}

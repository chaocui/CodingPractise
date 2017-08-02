package leetcode.Linkedin;

/**
 * Created by cc on 2017/6/23.
 */
public class CanIWin {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        boolean[] used = new boolean[maxChoosableInteger+1];
        return getResult(desiredTotal, used);
    }

    public boolean getResult(int desiredTotal, boolean[] used){
        if(desiredTotal <= 0) return false;
        //boolean result = true;
        for(int i = 1; i < used.length; i++){
            if(!used[i]){
                used[i] = true;
                if(!getResult(desiredTotal-i,used)) {
                    //This is the key part of this question
                    //before you return , you still set i back to false.
                    //since two players play smart, if either one can win, the other will try not let him win.
                    //so they may try another pick. which leads to a different status of game.
                    /**
                     * On top of this, we add cache to reduce recalculation of each status.
                     * each status is, same pick and left numbers.
                     * we can use Arrays.toString(boolean[]) to get an identical key.
                     * */

                    /**
                     * Another way of thinking about this is we trying to get the result of each status.
                     * So basically, if currently i can win, just store this status, and set i back to not picked,
                     * and see another status if i can win or not.
                     * */
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(10,10));
    }
}

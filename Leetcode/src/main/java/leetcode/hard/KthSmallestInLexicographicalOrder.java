package leetcode.hard;

/**
 * Created by cc on 2016/10/31.
 * https://discuss.leetcode.com/topic/64624/concise-easy-to-understand-java-5ms-solution-with-explaination/2
 *
 * See the problem as denary tree.
 *
 *                1 2 3 4 5 6 7 8 9
 *  10 11 12 13 14 15 16 17 18 19, 20 21 22 23 24 25 26 27 28 29
 * 100 101 102... 109, 110,..119
 *
 */
public class KthSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        int current = 1;
        int move = k - 1;
        //Loop until move k - 1 times. then it will be the kth element.
        while(move > 0){

            //See how many steps from current to current + 1 on same level.
            int steps = steps(n, current, current+1);
            //if steps less or equal than k, then move to right. move right takes steps and current become current + 1;
            if(steps <= k){
                current = current+1;
                move = move - steps;
            }
            //otherwise move down, move down always take 1 step and current become 10 times.
            else{
                current = current*10;
                move = move - 1;
            }
        }
        return current;
    }

    public int steps(int n, int n1, int n2){
        int steps = 0;
        while (n1 <= n) {

            if(n2 <= n){
                steps += (n2 - n1);
            }
            else{
                steps += (n+1-n1);
            }
            //steps += Math.min(n + 1, n2) - n1;
            //if n1 is less than n, we keep go to the next level in the denary tree.
            //calculate how many steps we need and sum them.
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

}

package leetcode.Airbnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by cc on 2017/6/29.
 */
public class RainWater {

    /**
     * Basic idea is get each position how much water we can hold,
     * then fill the deepest location/locations on each loop.
     * until there is no more water left.
     * */
    public void solution(int[] mountains, int rain, int pos){
        int[] waters = new int[mountains.length];
        waters[0] = 0;
        int max = mountains[0];
        int maxHeight = mountains[0];
        for(int i = 1; i < mountains.length; i++){
            maxHeight = Math.max(maxHeight, mountains[i]);
            if(mountains[i] >= max)
                max = mountains[i];
            else
                waters[i] = max - mountains[i];
        }
        waters[waters.length-1] = 0;
        max = mountains[mountains.length-1];
        for(int i = mountains.length-2; i >= 0; i--){
            if(mountains[i] >= max){
                max = mountains[i];
                waters[i] = 0;
            }
            else
                waters[i] = Math.min(waters[i], max - mountains[i]);
        }

        int[] fill = new int[waters.length];
        //now waters holds at each position, how much water it can contains.

        //we pour water to the deepest location on every loop
        //every loop we also update water(deepest location) used for next loop.
        while(rain > 0){
            int used = pourWater(waters, pos, fill);
            rain = rain - used;
        }

        for(int i = maxHeight; i >= 0; i--){
            for(int j = 0; j < waters.length; j++){
                if(mountains[j] + fill[j] < i){
                    System.out.print(" ");
                }
                else{
                    if(fill[j] > 0){
                        System.out.print("w");
                        fill[j] --;
                    }
                    else
                        System.out.print("+");
                }
            }
            System.out.println();
        }
    }

    /**
     * Stratagy here is use stack to keep left and right, until we hit less than.
     * Because water goes to lower place. we need to find the place can contain the most water, and fill them first.
     * then do it again to fill.
     * */
    public int pourWater(int[] water, int pos, int[] fill){
        //check left and right, possibility of holding water.
        Stack<Integer> stackRight = new Stack<>();
        Stack<Integer> stackLeft = new Stack<>();
        //there is possibility that current position can hold more water than both direction.
        stackLeft.push(pos);
        stackRight.push(pos);
        for(int i = pos+1; i < water.length; i++){
            if(water[i] >= water[i-1])
                stackRight.push(i);
            else break;
        }
        for(int i = pos - 1; i >= 0; i--){
            if(water[i] >= water[i+1])
                stackLeft.push(i);
            else break;
        }
        //either stack is empty, means cannot flow to right.
        //or stack top(maximum one) is same as current position. might flow left.
        //so we need to check left.
        int waterUsed = 0;
        //if both empty, means water goes current position, which is in both stacks, we just pick any one.
        if(stackLeft.isEmpty() && stackRight.isEmpty()){
            waterUsed = updateWater(extractMaxFromStack(water, stackLeft), water, fill);
        }
        //just remember we need to compare the value in array. not the index.
        //go left
        else if(stackRight.isEmpty() || (!stackLeft.isEmpty() && water[stackLeft.peek()] >= water[stackRight.peek()])){
            waterUsed = updateWater(extractMaxFromStack(water, stackLeft), water, fill);
        }
        //go right
        else if(stackLeft.isEmpty() || (!stackRight.isEmpty() && water[stackRight.peek()] >= water[stackLeft.peek()])){
            waterUsed = updateWater(extractMaxFromStack(water, stackRight), water, fill);
        }
        return waterUsed;
    }

    //extract the maximum(may be continuous) indexes. what in stack is index, so when compare, we need water array to get the value to compare.
    public List<Integer> extractMaxFromStack(int[] water, Stack<Integer> stack){
        List<Integer> result = new ArrayList<>();
        result.add(stack.pop());
        while(!stack.isEmpty() && water[result.get(0)] == water[stack.peek()])
            result.add(stack.pop());
        return result;
    }

    //return how much water used
    //update the each slot how much water we can fill, and how much we filled for each slot(for output print)
    public int updateWater(List<Integer> indexes, int[] water, int[] fill){
        for(int i : indexes) {
            water[i]--;
            fill[i]++;
        }
        return indexes.size();
    }

    public static void main(String[] args) {
        RainWater rw = new RainWater();
        int[] mountains = {5,4,2,1,2,3,2,1,0,1,2,4};
        rw.solution(mountains, 9 , 5);
    }
}

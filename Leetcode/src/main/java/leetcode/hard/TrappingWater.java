package leetcode.hard;

/**
 * Created by cc on 2016/11/13.
 */
public class TrappingWater {

    //Basic idea,
    //loop from left to right, find water for each place,(Tracking left max, if current < left max, subtract, else, 0)
    //loop from right to left, do the same thing, then take the smaller one between this loop and previous loop.
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int result = 0;
        int trappingWater[] = new int[height.length];
        int leftMax = height[0];
        trappingWater[0] = 0;
        for(int i  = 1; i < height.length; i++){
            int currentHeight = height[i];
            if(currentHeight >= leftMax){
                trappingWater[i] = 0;
                leftMax = currentHeight;
            }
            else{
                trappingWater[i] = leftMax - currentHeight;
            }
        }
        int rightMax = height[height.length-1];
        trappingWater[height.length - 1] = 0;
        for(int i = height.length - 2; i >= 0; i--){
            int currentHeight = height[i];
            if(currentHeight >= rightMax){
                trappingWater[i] = 0;
                rightMax = currentHeight;
            }
            else{
                trappingWater[i] = Math.min(trappingWater[i], rightMax - currentHeight);
            }
            result += trappingWater[i];
        }
        return result;
    }
}

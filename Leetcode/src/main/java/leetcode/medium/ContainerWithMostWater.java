package leetcode.medium;

/**
 * Created by cc on 2016/7/21.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int areaMax = 0;
        while(left < right){
            int area = (right - left) * min(height[left], height[right]);
            areaMax = max(areaMax, area);
            if(height[left] < height[right]){
                left++;
            }
            else if(height[left] > height[right]){
                right--;
            }
            else{
                left ++;
                right --;
            }
        }
        return areaMax;
    }

    private int min(int a, int b){
        return a >= b ? b : a;
    }
    private int max(int a, int b){
        return a >= b ? a : b;
    }
}

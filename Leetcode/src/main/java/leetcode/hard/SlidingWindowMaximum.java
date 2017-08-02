package leetcode.hard;

import java.util.LinkedList;

/**
 * Created by cc on 2016/11/7.
 */
public class SlidingWindowMaximum {
    //Use deque
    //Loop through all elements in nums
    //For deque, we do following:

    //If it's empty, then add elements to queue

    //If not && current element is greater than last element in queue,
    //Remove last until current is less than last.

    //Check if the first element is out of window, i - first >= k

    //Start to adding result if i+1-k>=0

    //Reason why this work:
    //For each element in nums,
    //If less than last, add to deque

    //Solution 2: slower, easier, use heap.
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k == 0){
            return new int[0];
        }

        int result[] = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<Integer>();

        for(int i = 0; i < nums.length; i++){
            /**
             * In queue, means that this element is still in window(This is guaranteed in line 48, which is out window, we remove it.)
             * if deque is not empty && current element greater or equal to last element.
             * Remove the last, since the smaller one has no chance to be maximum in window
             * */
            while(!deque.isEmpty() && nums[i] >= nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.add(i);

            //We check current index with the first largest difference to make sure the largest is still in window.
            //If not we remove it.
            if(i-deque.getFirst() >= k){
                deque.removeFirst();
            }
            //Only add result from 0, which is i+1>=k
            if(i+1>=k){
                result[i+1-k] = nums[deque.getFirst()];
            }
        }
        return result;
    }
}

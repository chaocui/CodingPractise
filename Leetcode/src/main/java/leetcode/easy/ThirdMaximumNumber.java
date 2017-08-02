package leetcode.easy;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/4/20.
 */
public class ThirdMaximumNumber {
    //Use heap, proximately O(n)
    //Easy issues, 解题思路很简单。
    //但是处处是陷阱啊... 一次写对很重要...
    //但是处处是陷阱啊... 一次写对很重要...
    //但是处处是陷阱啊... 一次写对很重要...
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(3);
        for(int n : nums){
            if(!minHeap.contains(n)) {
                if (minHeap.isEmpty() || minHeap.size() < 3)
                    minHeap.add(n);
                else if (n > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(n);
                }
            }
        }
        if(minHeap.size() < 3){
            int result = 0;
            while(!minHeap.isEmpty()){
                result = minHeap.poll();
            }
            return result;
        }
        return minHeap.peek();
    }
}

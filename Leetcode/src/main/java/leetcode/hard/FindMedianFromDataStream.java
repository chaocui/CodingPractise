package leetcode.hard;

import java.util.PriorityQueue;

/**
 * Created by cc on 2017/4/15.
 */
public class FindMedianFromDataStream {

    /**
     * Basic idea, Use two heaps.
     * 1. minHeap,
     * 2. maxHeap,
     *
     * Use lambda as many as I can!!!!!!!!!!!!!!!!!!!!
     *
     * First of all, use lambda, practice.
     * Basic idea.
     * --- When get median.
     * if size equal and not 0, return (peek() + peek()) /2
     * else if which one has more element, return the peek() of that heap
     * This is for all heap are empty. else return 0.0.
     *
     * --- When add number
     * --- if < max.peek() means it belongs to the first half.
     * --- otherwise means it belongs to the second half.
     *
     * if maxNot empty && num < max.peek()
     * add to max.
     * if max has 2 more than min, pop max, add to min.
     * else
     * add to min,
     * if min has 2 more than max, pop min, add to max.
     * */
    /** initialize your data structure here. */

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        if(!maxHeap.isEmpty() && num < maxHeap.peek()){
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() == 2)
                minHeap.add(maxHeap.poll());
        }
        else{
            minHeap.add(num);
            if(minHeap.size() - maxHeap.size() == 2)
                maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        int sizeMin = minHeap.size();
        int sizeMax = maxHeap.size();
        if(sizeMin != 0 && sizeMax != 0 && sizeMin == sizeMax)
            return ((double)((minHeap.peek() + maxHeap.peek())))/ 2;
        else if(sizeMin > sizeMax)
            return (double)minHeap.peek();
        else if(sizeMax > sizeMin)
            return (double)maxHeap.peek();
        else return 0.0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream fmfds = new FindMedianFromDataStream();
        fmfds.addNum(1);
        fmfds.addNum(2);
        System.out.println(fmfds.findMedian());
    }

}

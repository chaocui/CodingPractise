package leetcode.medium;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/3/18.
 */
public class SuperUglyNumber {

    public class SimpleObject {
        int val;
        int index;

        public SimpleObject(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public class SOC implements Comparator<SimpleObject> {
        @Override
        public int compare(SimpleObject o1, SimpleObject o2) {
            return o1.val - o2.val;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        PriorityQueue<SimpleObject> minHeap = new PriorityQueue<SimpleObject>(len, new SOC());
        //keep track of each prime number factor base position in result, initially all 0s.
        int[] index = new int[len];
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 0; i < len; i++){
            SimpleObject so = new SimpleObject(primes[i],i);
            minHeap.add(so);
        }

        for(int i  = 1; i < n; i++){
            result[i] = minHeap.peek().val;
            //Handle duplicates. important!!!
            //we take result[i] as the peek.
            //Then for the heap, if peek == result[i] , we pop and process and add new.
            //until the peek is no-longer equal to result[i].
            //we go to the next result position.
            while(minHeap.peek().val == result[i]){
                SimpleObject so = minHeap.poll();
                int pIndex = so.index;
                //the index in result need to increase.
                index[pIndex]++;
                //add new ugly number to heap.
                //value is primes[pIndex] * result[index[pIndex]]
                SimpleObject so1 = new SimpleObject(primes[pIndex]*result[index[pIndex]],pIndex);
                minHeap.add(so1);
            }
        }
        return result[n-1];
    }

    public static void main(String[] args) {
        SuperUglyNumber sun = new SuperUglyNumber();
        int[] test = {3,5,7,11,19,23,29,41,43,47};
        int[] test1 = {2,3,5};
        System.out.println(sun.nthSuperUglyNumber(15,test));
    }

}
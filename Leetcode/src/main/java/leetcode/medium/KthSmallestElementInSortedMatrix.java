package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cc on 2016/8/4.
 */
public class KthSmallestElementInSortedMatrix {

    public class CompareElement implements Comparator<Element> {
        public int compare(Element a, Element b){
            return a.v - b.v;
        }
    }

    public class Element{
        int x, y, v;

        public Element(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Element> minHeap = new PriorityQueue<>(new CompareElement());

        for(int i = 0; i < matrix[0].length; i++){
            minHeap.add(new Element(0, i, matrix[0][i]));
        }

        //Run 1 time, return 2 smallest,
        //Return k smallest, run k-1 times.
        for(int i = 0 ; i < k - 1; i++){
            Element e = minHeap.poll();
            if(e.x < matrix.length-1){
                Element newE = new Element(e.x + 1, e.y, matrix[e.x+1][e.y]);
                minHeap.add(newE);
            }
        }
        return minHeap.peek().v;
    }

    public static void main(String[] args){
        int test[][] = new int[][]{
                {1,2},
                {1,3}
        };

        KthSmallestElementInSortedMatrix k = new KthSmallestElementInSortedMatrix();
        System.out.println(k.kthSmallest(test,2));
    }
}

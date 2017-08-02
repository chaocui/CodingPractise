package leetcode.Uber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cc on 2017/6/11.
 */
public class RearrangeCharactersTwoAdjacentNoTheSame {
    /**
     *  Count frequency of each character,
     *  put them in maxHeap.
     * */

    public class Count{
        int count;
        char c;
        public Count(int count, char c){
            this.count = count;
            this.c = c;
        }
    }

    public String rearrange(String s){
        int[] count = new int[256];
        for(char c : s.toCharArray())
            count[c]++;
        PriorityQueue<Count> maxHeap = new PriorityQueue<>(new Comparator<Count>() {
            @Override
            public int compare(Count o1, Count o2) {
                return o2.count - o1.count;
            }
        });
        for(int i = 0; i < 256; i++){
            if(count[i] != 0){
                maxHeap.offer(new Count(count[i], (char)i));
            }
        }
        List<Count> tempList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        /**
         * A different idea is:
         * We dont need a list.
         * We can just use a variable hold the previous count object.
         * Every time we assign current to pre.
         * if pre.count > 0, add back to heap.
         * Then if heap is empty, and if pre still hold characters.
         * then string is shorter than the original one, return not possible.
         * otherwise, return string.
         *
         * */
        while(!maxHeap.isEmpty()){
            Count current = maxHeap.poll();
            //Every time we poll from heap,
            //we check if both heap and tempList are empty and the only left character has more than 1 count.
            //if yes, return not possible.
            if(maxHeap.isEmpty() && tempList.isEmpty() && current.count > 1) return "Not Possible";

            //if not, means that we still good to generate result.
            sb.append(current.c);
            current.count--;
            //if there is previous char in tempList, we add it back to heap to use it since there is already a
            //different char inserted into result.
            if(!tempList.isEmpty()){
                maxHeap.add(tempList.get(0));
                //remove it from list
                tempList.clear();
            }
            //if current still has left. add to tempList, add it back in next loop.
            if(current.count > 0)
                tempList.add(current);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeCharactersTwoAdjacentNoTheSame rctants = new RearrangeCharactersTwoAdjacentNoTheSame();
        System.out.println(rctants.rearrange("aaabc"));
    }

}

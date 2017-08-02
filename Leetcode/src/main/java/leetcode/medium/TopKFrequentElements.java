package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2016/8/6.
 */
public class TopKFrequentElements {

    public class FrequencyCount{
        int count, value;
        public FrequencyCount(int value, int count){
            this.count = count;
            this.value = value;
        }
    }

    public class FrequencyComparator implements Comparator<FrequencyCount> {
        public int compare(FrequencyCount fc1, FrequencyCount fc2){
            return fc2.count - fc1.count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        PriorityQueue<FrequencyCount> maxHeap = new PriorityQueue(new FrequencyComparator());
        HashMap<Integer, Integer> dic = new HashMap();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(dic.containsKey(nums[i])){
                int count = dic.get(nums[i]) + 1;
                dic.put(nums[i], count);
            }
            else{
                dic.put(nums[i], 1);
            }
        }

        for(HashMap.Entry<Integer, Integer> each : dic.entrySet()){
            FrequencyCount fc = new FrequencyCount(each.getKey(), each.getValue());
            maxHeap.add(fc);
        }

        for(int i = 0; i < k; i++){
            FrequencyCount fc = maxHeap.poll();
            result.add(fc.value);
        }

        return result;
    }
}

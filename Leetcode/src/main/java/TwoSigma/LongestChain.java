package TwoSigma;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2016/7/26.
 */
public class LongestChain {

    public class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public int longestChain(String[] strings){

        Arrays.sort(strings, new LengthComparator());
        Map<String, Integer> tracker = new HashMap<>();
        int result = 1;

        for(int i = 0; i < strings.length; i++){
            if(strings[i].length() == 1){
                tracker.put(strings[i], 1);
            }
            else{
                boolean found = false;
                //find all strings that has deleted one char,
                //See any of them in the tracker, if yes,
                //current string path will be the one in tracker count + 1;
                for(int j = 0; j < strings[i].length(); j++){
                    StringBuilder sb = new StringBuilder(strings[i]);
                    sb.delete(j, j+1);
                    String newString = sb.toString();
                    if(tracker.containsKey(newString)){
                        int count = tracker.get(newString) + 1;
                        result = Math.max(result, count);
                        tracker.put(strings[i], result);
                        found = true;
                    }
                }
                //if not found any in tracker, then current string can only have chain length 1.
                if(!found){
                    tracker.put(strings[i],1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){

        LongestChain lc = new LongestChain();
        String test[] = {"a", "abdf", "bcd", "abd", "acd", "c"};
        System.out.println(lc.longestChain(test));

    }

}

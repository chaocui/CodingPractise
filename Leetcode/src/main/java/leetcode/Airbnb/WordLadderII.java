package leetcode.Airbnb;

import java.util.*;

/**
 * Created by cc on 2017/6/30.
 */
public class WordLadderII {

    /**
     * basic idea is using map to track end word and the path to this end.
     *
     * */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<List<String>>> result = new HashMap<>();
        List<List<String>> iPath = new ArrayList<>();
        List<String> iList = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        iList.add(beginWord);
        iPath.add(iList);
        result.put(beginWord, iPath);
        boolean find = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            Map<String, List<List<String>>> currentLevel = new HashMap<>();
            //whole level
            for(int i = 0; i < size; i++){
                String beforeChange = queue.poll();
                //one word in this level
                for(int m = 0; m < beforeChange.length(); m++) {
                    StringBuilder current = new StringBuilder(beforeChange);
                    for (int n = 0; n < 25; n++) {
                        current.setCharAt(m, (char)(n+'a'));
                        String changed = current.toString();

                        //if not in dict, or already calculated previous level which is shorter, skip
                        if(!dict.contains(changed) || result.containsKey(changed))
                            continue;

                        List<List<String>> currentPath = result.get(beforeChange);
                        //if current level, changed is not calculated yet
                        //we need to add to queue.
                        //if already calculated, means we already added to queue, dont need to add,
                        //just expand result.
                        if(!currentLevel.containsKey(changed)) {
                            queue.offer(changed);
                            currentLevel.put(changed, new ArrayList<List<String>>());
                        }
                        for(List<String> each : currentPath){
                            List<String> copyEach = new ArrayList<>(each);
                            copyEach.add(changed);
                            currentLevel.get(changed).add(copyEach);
                        }

                        if(changed.equals(endWord))
                            find = true;
                    }
                }
            }
            //after processing this level, if find target, dont need to continue, we found all the shortest path.
            if(find) return currentLevel.get(endWord);
            //otherwise, add currentLevel to result.
            result.putAll(currentLevel);
        }
        return new ArrayList<List<String>>();
    }
}

package leetcode.Snapchat;

import java.util.*;

/**
 * Created by cc on 2017/6/22.
 */
public class WordAbbreviation {

    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> result = new ArrayList<>();
        //Track for each abbr, the indexes has the same abbr
        Map<String, List<Integer>> track = new HashMap<>();
        //Pre process
        for(int i = 0; i < dict.size(); i++){
            String s = dict.get(i);
            if(s.length() <= 3){
                result.add(s);
                track.put(s, new ArrayList<Integer>());
                track.get(s).add(i);
            }
            else{
                String abbr = s.charAt(0) + "" + (s.length()-2) + s.charAt(s.length()-1);
                result.add(abbr);
                if(!track.containsKey(abbr))
                    track.put(abbr, new ArrayList<Integer>());
                track.get(abbr).add(i);
            }
        }

        while(track.size() != dict.size()){
            //To avoid concurrent modification, we use two separate map to track which get modified.
            Set<String> keys = new HashSet<>();
            Map<String, List<Integer>> newCount = new HashMap<>();
            for(Map.Entry<String, List<Integer>> each : track.entrySet()){
                if(each.getValue().size() > 1){
                    List<Integer> indexes = each.getValue();
                    for(int i = 0; i < indexes.size(); i++){
                        int index = indexes.get(i);
                        String newAbbr = extendPrefix(dict.get(index), result.get(index));
                        if(!newCount.containsKey(newAbbr))
                            newCount.put(newAbbr, new ArrayList<Integer>());
                        newCount.get(newAbbr).add(index);
                        result.remove(index);
                        result.add(index,newAbbr);
                    }
                    keys.add(each.getKey());
                }
            }
            for(String key : keys)
                track.remove(key);
            track.putAll(newCount);
        }
        return result;
    }

    //instead of extending the prefix,
    //we just generate length k prefix for the abbr
    //in order to do this, we need an extra array to keep track of prefix length.
    public String extendPrefix(String s, String abbr){
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < s.length() && j < abbr.length()){
            if(s.charAt(i) == abbr.charAt(j)){
                i++;j++;
                continue;
            }
            int start = j;
            while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9')
                j++;
            int num = Integer.parseInt(abbr.substring(start, j));
            if(num - 1 == 1)
                return s;
            sb.append(s.substring(0,start+1)).append(num-1).append(s.charAt(s.length()-1));
            break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WordAbbreviation wa = new WordAbbreviation();
        System.out.println(wa.extendPrefix("internal", "inter2l"));
    }

}

package leetcode.medium;

import java.util.*;

/**
 * Created by cc on 2017/3/7.
 */
public class GroupAnagrams {

    //Basic idea is make a class which is wrapper of string.
    //So we can override hash code and equals function.
    //hash code and equals function are based on sorted string. which is modifiedS.
    public class StringWrapper{
        public String s, modifiedS;
        public char[] ca;
        public StringWrapper(String s){
            this.s = s;
            ca = s.toCharArray();
            Arrays.sort(ca);
            modifiedS = String.valueOf(ca);
        }

        public int hashCode(){
            return modifiedS.hashCode();
        }

        public boolean equals(Object sw){
            if(sw instanceof StringWrapper){
                return modifiedS.equals(((StringWrapper) sw).modifiedS);
            }
            return false;
        }

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<StringWrapper, List<String>> tracker = new HashMap<StringWrapper, List<String>>();
        for(String s: strs){
            StringWrapper sw = new StringWrapper(s);
            if(tracker.containsKey(sw))
                tracker.get(sw).add(s);
            else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                tracker.put(sw,temp);
            }
        }
        return new ArrayList<List<String>>(tracker.values());
    }
}

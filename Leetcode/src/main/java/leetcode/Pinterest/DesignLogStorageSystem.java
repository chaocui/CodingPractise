package leetcode.Pinterest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2017/7/4.
 */
public class DesignLogStorageSystem {

    /**
     * Just use list to compare?
     * */
    List<String[]> times = new ArrayList<String[]>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] index = {4, 7, 10 , 13, 16, 19};
    public DesignLogStorageSystem() {
    }

    public void put(int id, String timestamp) {
        times.add(new String[]{id+"", timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> result = new ArrayList<>();
        int subStringIndex = index[units.indexOf(gra)];
        for(String[] sl : times){
            if(sl[1].substring(0,subStringIndex).compareTo(s.substring(0,subStringIndex)) >= 0 &&
                    sl[1].substring(0,subStringIndex).compareTo(e.substring(0,subStringIndex)) <= 0 )
                result.add(Integer.parseInt(sl[0]));
        }
        return result;
    }

}

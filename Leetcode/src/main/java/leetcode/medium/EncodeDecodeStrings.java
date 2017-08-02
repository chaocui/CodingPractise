package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/5/17.
 */
public class EncodeDecodeStrings {

    /**
     * Easy idea, is just keep length and string, separate by /
     * when decode, the part before first / always be the length,
     * so just take substring based on this size.
     * */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        int i = 0;
        while(i < s.length()){
            //i is the starting index from where start to search
            int indexOfCurrentSlash = s.indexOf("/",i);
            int size = Integer.parseInt(s.substring(i,indexOfCurrentSlash));
            result.add(s.substring(indexOfCurrentSlash+1,indexOfCurrentSlash+size+1));
            i = indexOfCurrentSlash+size+1;
        }
        return result;
    }

}

package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
    	Set<String> dup = new HashSet<String>(), result = new HashSet<String>();
    	for(int i = 0; i < s.length()-9; i++){
    		String temp = s.substring(i,i+10);
    		//if add to set fail, means this is dup, so add to result
    		//the reason why result is a set is because that one sequence repeat more than twice.
    		//so set will not have duplicate result.
    		if(!dup.add(temp))
    			result.add(temp);
    	}
    	return new ArrayList<String>(result);
    } 
}

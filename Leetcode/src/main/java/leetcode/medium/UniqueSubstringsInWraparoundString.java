package leetcode.medium;


public class UniqueSubstringsInWraparoundString {

	/**
	 * The max number of unique substring ends with a letter equals to the length of max contiguous substring ends with that letter. 
	 * Example "abcd", the max number of unique substring ends with 'd' is 4, apparently they are "abcd", "bcd", "cd" and "d".
	   If there are overlapping, we only need to consider the longest one because it covers all the possible substrings. 
	   Example: "abcdbcd", the max number of unique substring ends with 'd' is 4 and all substrings formed by the 2nd "bcd" part 
	   are covered in the 4 substrings already.
	 * */
	
	/**
	 * Basic idea is keep track of substrings that end with each character.
	 * take the maximum length.
	 * 
	 * abcdcd. end with a max is 1, b is 2, c is 3, d is 4. so total is 1+2+3+4;
	 * 
	 * for second d, end with d the substring is cd which is length 2, less than 4. so we still take 4.
	 * */
    public int findSubstringInWraproundString(String p) {
        if(p.length() <= 1) return p.length();
        int length = 1; int result = 0;
        //keep track
        int[] substringLen = new int[26];
        //Initial the first char
        char fc = p.charAt(0);
        substringLen[fc-'a'] = 1;
        
        //Loop starting from i =1;
        for(int i = 1; i < p.length(); i++){
        	char c = p.charAt(i);
        	char cP = p.charAt(i-1);
        	if(c - cP == 1 || c - cP == -25){
        		length ++;
        	}
        	else{
        		length = 1;
        	}
        	substringLen[c-'a'] = Math.max(length, substringLen[c-'a']);
        }
        
        //if last char is not part of previous substring.
        //we take care of it.
        if(length == 1){
        	char lc = p.charAt(p.length() - 1);
        	substringLen[lc - 'a'] = Math.max(length, substringLen[lc -'a']);
        } 
        
        for(int i : substringLen)
        	result+=i;
        return result;
    }
	
    
    public static void main(String[]  args){
    	//System.out.println('a' - 'z');
    	UniqueSubstringsInWraparoundString usiws = new UniqueSubstringsInWraparoundString();
    	System.out.println(usiws.findSubstringInWraproundString("zab"));
    }
}

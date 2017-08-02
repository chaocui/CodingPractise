package leetcode.medium;

/**
 * Created by cc on 2017/5/20.
 */
public class SplitConcatenatedString {

    /**
     * Basic idea is
     * 1. Find the maximum character, since result must start with this character.
     * 2. For each string, we take either itself or its reverse, depending on which is bigger.
     * 3. Then loop through the string array, find character equals to max.
     * 4. Construct a result,
     *      1. substring m to string end
     *      2. concatenate following strings in string array
     *      3. concatenate previous strings in string array.
     *      4. concatenate 0 to m in current string.
     *
     * One thing need to notice is
     * For current string has maximum character,
     * we need to check both itself and its reverse.
     * Since we dont know which sequence after cutting result in maximum.
     * */
    public String splitLoopedString(String[] strs) {
        char max = 'a';
        //Find the maximum character in the concatinate string.
        //The result must start with this char.
        //Also for each string
        //Compare itself with the reverse. Take the bigger one.
        for(int i = 0; i < strs.length; i++){
            for(char c : strs[i].toCharArray()){
                if(max < c) max = c;
            }
            StringBuilder sb = new StringBuilder(strs[i]).reverse();
            if(strs[i].compareTo(sb.toString()) < 0)
                strs[i] = sb.toString();
        }

        /**
         * Loop through the string array.
         * Find the string we need to cut.
         * For this one, we need to compare cut in this string which one is bigger,
         * 1. the one with the reverse one
         * 2. the one with the normal one.
         * Take the bigger one.
         * */
        String result = "";
        for(int i = 0; i < strs.length; i++){
            String reverse = new StringBuilder(strs[i]).reverse().toString();
            /**
             * Check both orignal and its reverse
             * find the char which equals max
             * */
            for(String s : new String[]{strs[i], reverse}){
                /**
                 * Only if char == max, this is a possible result.
                 * */
                for(int m = 0; m < s.length(); m++){
                    if(s.charAt(m) == max){
                        StringBuilder temp = new StringBuilder(s.substring(m));
                        //Appending all following strings to result
                        for(int j = i+1; j < strs.length; j++)
                            temp.append(strs[j]);
                        //Appending all previous strings to result
                        for(int j = 0; j < i; j++)
                            temp.append(strs[j]);
                        //Appending strs[i] previous chars to result.
                        temp.append(s.substring(0,m));
                        if(temp.toString().compareTo(result)>0) result = temp.toString();
                    }
                }
            }
        }
        return result;
    }
}

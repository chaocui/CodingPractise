package leetcode.medium;

/**
 * Created by cc on 2017/3/18.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    //Basic idea,
    //divide and conquer.

    //!!!important part is found each character that not satisfy k, meaning count between 0 and k.
    //we split the whole array into left and right.
    //do the same thing.
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return getResult(chars, 0, s.length() - 1, k);
    }

    private int getResult(char[] chars, int start, int end, int k){
        int[] count = new int[26];
        //count number of the each characters in chars
        for(int i = start; i <= end; i++){
            int index = chars[i] - 'a';
            count[index] ++;
        }

        for(int i = 0; i < 26; i++){
            if(count[i] < k && count[i] > 0){
                //loop through start to end, find all the un-satisfy characters
                //divide to left and right, do the same thing recursively.
                for(int j = start; j <= end; j++){
                    if(chars[j] == i + 'a'){
                        int left = getResult(chars, start, j - 1, k);
                        int right = getResult(chars, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start + 1;
    }
}

package leetcode.medium;

/**
 * Created by cc on 2016/8/7.
 */
public class MaximumProdOfWordLength {
    public int maxProduct(String[] words) {

        int preProc[] = new int[words.length];
        int result = 0;

        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray()){
                preProc[i] = preProc[i] | (1 << (c-'a'));
            }
        }

        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if((preProc[i] & preProc[j]) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}

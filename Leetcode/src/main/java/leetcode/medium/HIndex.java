package leetcode.medium;

/**
 * Created by cc on 2017/1/26.
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        int length = citations.length;
        //For each one, we use the value as index,
        //count the number for this value.
        for(int i = 0; i < length; i++){
            if(citations[i] > length){
                count[length] += 1;
            }
            else{
                count[citations[i]] += 1;
            }
        }
        int sum = 0;
        for(int i = length; i >= 0; i--){
            sum += count[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }

}

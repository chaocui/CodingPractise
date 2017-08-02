package leetcode.medium;

/**
 * Created by cc on 2017/4/3.
 */
public class BeautifulArrangement {

    public int countArrangement(int N) {
        int[] result = new int[1];
        int[] track = new int[N+1];
        getResult(N, 1, result, track);
        return result[0];
    }

    public void getResult(int n, int pos, int[] result, int[] track){
        if(pos > n){
            result[0]++;
            return;
        }
        for(int i = 1; i <= n; i++){
            //if number i is not used, and satisfy beautiful arrangement.
            //i % pos == 0 || pos % i  == 0
            if(track[i] == 0 && (i % pos == 0 || pos % i == 0)){
                track[i] = 1;
                getResult(n, pos+1, result, track);
                //after recursion, set it not used, so backtracing.
                track[i] = 0;
            }
        }
    }

}

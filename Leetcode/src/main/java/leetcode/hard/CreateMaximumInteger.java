package leetcode.hard;

/**
 * Created by cc on 2016/11/3.
 */
public class CreateMaximumInteger {

    //DP
    //matrix size n*n
    //row means how many digits
    //column means from this position to end of integer, biggest number
    //DP function
    //dp[i][j] = Math.max(dp[i][j+1], a[j-1]*Math.pow(10,k) + dp[i-1][j+1]);
    public int[] maxIntegerFromArray(int[] a){
        int l = a.length;
        StringBuilder sb = new StringBuilder();
        for(int i : a){
            sb.append(i);
        }
        int dp[][] = new int[l+1][l];
        for(int i = 1; i <= l; i++){
            dp[i][l-i] = Integer.parseInt(sb.substring(l-i));
        }
        for(int i = 1; i < l; i++){
            for(int j = l-i-1; j >=0; j--){
                int num = a[j];
                int tempMax = num*(int)Math.pow(10,i-1)+dp[i-1][j+1];
                dp[i][j] = Math.max(dp[i][j+1],tempMax);
            }
        }
        int result[] = new int[l+1];
        for(int i = 1; i <= l; i++){
            result[i] = dp[i][0];
        }
        return result;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] nums1MaxArray = maxIntegerFromArray(nums1);
        int[] nums2MaxArray = maxIntegerFromArray(nums2);
        int largest = Integer.MIN_VALUE;

        //Need to write a merge function also.
        for(int i = 0; i < k; i++){
            //0 from num1, k from num2
            //k from num1, 0 from num2;
            //merge them.
            //compare get the biggest, update current biggest.

        }
        //convert largest to array
        return new int[k];
    }

    public static void main(String[] args){
        CreateMaximumInteger cmi = new CreateMaximumInteger();
        int test[] = {9,1,2,5,8,3};
        int[] result = cmi.maxIntegerFromArray(test);
        for(int i : result){
            System.out.println(i);
        }

    }

}

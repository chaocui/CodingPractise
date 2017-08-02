package Bloomberg;

import leetcode.medium.MaximumProductSubarray;

/**
 * Created by cc on 2016/9/7.
 */
public class MaxSumInTwoArray {

    public int maxSum(int[] a, int[] b){
        int result = 0;
        int sumA = 0;
        int sumB = 0;

        int i = 0, j = 0;
        while(i < a.length && j < b.length){

            if(a[i] < b[j]){
                sumA += a[i];
                i++;
            }
            else if(a[i] > b[j]){
                sumB += b[j];
                j++;
            }
            else{
                result = result + Math.max(sumA, sumB) + a[i];
                i++;
                j++;
                sumA = 0;
                sumB = 0;
            }
        }

        while(i < a.length){
            sumA += a[i];
            i++;
        }

        while(j < b.length){
            sumB += b[j];
            j++;
        }

        result = result + Math.max(sumA, sumB);

        return result;
    }

    public static void main(String[] args){
        int ar1[]  = {2, 3, 7, 10, 12, 15, 30, 34};
        int ar2[] =  {1, 5, 7, 8, 10, 15, 16, 19};

        MaxSumInTwoArray msit = new MaxSumInTwoArray();
        System.out.println(msit.maxSum(ar1, ar2));
    }


}

package leetcode.medium;

public class RotateFunction {
	
	
	//数学归纳法 推导递推公式
	//F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-2) * Bk[n-2] + (n-1) * Bk[n-1] --- k = 0;
	//F(k+1) = 0 * Bk[n-1] + 1 * Bk[0] + 2 * Bk[1] + ... + (n-1) * Bk[n-2] --- k = 0;
	//F(k+1) - F(k) = Bk[0] + Bk[1] + .... Bk[n-2]  - n*Bk[n-1] + Bk[n-1]
	//F(k+1) = F(k) + sum - n * Bk[n-1];
	//Since k = 0 == > F(k+1) = F(k) + sum - n * Bk[n-1-k];
	//F(k) = F(k-1) + sum - n * Bk[n-1-k+1]
	//F(k) = F(k-1) + sum - n * Bk[n-k]
	public int maxRotateFunction(int[] A) {
        int F = 0; 
        int len = A.length;
        int sum = 0;
        for(int i = 0; i < A.length; i ++){
        	F = F + i*A[i];
        	sum = sum + A[i];
        }
        
        int max = F;
        for(int i = len - 1; i >= 1; i --){
        	F = F + sum - len*A[i];
        	max = Math.max(max, F);
        }
        
        return max;
    }
}

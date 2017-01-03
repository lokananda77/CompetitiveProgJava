package FbInterview;

public class MaxSubArray {
	public static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            
            //max is tracking the best subsum calculated upto the point i?
            //no dp[i] is what is what is calculatin that
            
            System.out.println("max:" + max + " dp[i]:" + dp[i]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
	}
	
	public static void main(String[] args) {
		int [] A = {2,3,-1, -10,6,7};
		System.out.println(maxSubArray(A));
	}
}

package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    static int MOD = 1_000_000_007;
    static long topDown(int n) {
        if (n <= 1) return n;
        
        long prev1 = 0, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            long curr = (prev1 + prev2)%MOD;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
    
    static long bottomUpFibo(int n,long[] dp){
        if (n <= 1) return n;
        
        if (dp[n] != -1) return dp[n];

        return dp[n] = (bottomUpFibo(n - 1, dp) + bottomUpFibo(n - 2, dp))%MOD;
    }

    static long bottomUp(int n) {
        long [] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return bottomUpFibo(n,dp);
    }
}

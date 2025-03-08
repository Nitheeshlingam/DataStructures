package DynamicProgramming;

//recursion
public class FrogJump {
    private static int frogJump(int ind,int [] height){
        if(ind == 0)return 0;
        int left = frogJump(ind-1,height)+Math.abs(height[ind]-height[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind >1){
            right = frogJump(ind-2,height)+Math.abs(height[ind]-height[ind-2]);
        }
        return Math.min(left,right);
    }
    int minCost(int[] height) {
        int n = height.length;
        return frogJump(n-1,height);
    }
    
}
//memoization
class Solution {
    private static int frogJump(int ind,int [] height, int[] dp){
        if(ind == 0)return 0;
        if(dp[ind] != -1) return dp[ind];
        int left = frogJump(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind >1){
            right = frogJump(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);
        }
        return dp[ind] = Math.min(left,right);
    }
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        return frogJump(n-1,height,dp);
    }
}

//Tabulation
class Solution2{
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        for(int i=1; i<n; i++){
            int fs =dp[i-1]+ Math.abs(height[i]-height[i-1]);
            int ss = Integer.MAX_VALUE; 
            if(i > 1){
                ss =dp[i-2]+ Math.abs(height[i]-height[i-2]);
            }
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
}

//K JUMP STEPS

class Solution3{
    static int solveUtil1(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; 
    }
    private static int solveUtil(int ind,int[] dp,int k,int [] height){
        if(ind == 0) return 0;
        
        if(dp[ind]!=-1) return dp[ind];
        
        int mmSteps = Integer.MAX_VALUE;
        
        for(int j=1; j<=k; j++){
            if(ind - j>=0){
                int jump = solveUtil(ind - j, dp, k, height)+Math.abs(height[ind]-height[ind-j]);
                mmSteps = Math.min(jump,mmSteps);
            }
        }
        return dp[ind] = mmSteps;
    }
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int [] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i]=-1;
        }
        return solveUtil(n-1,dp,k,arr);
    }
}

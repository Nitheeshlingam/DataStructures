package DynamicProgramming;

import java.util.Arrays;

//recursion
public class MaxSumWithoutAdjacent {
    private int maxSum(int[] nums,int ind){
        if(ind == 0) return nums[0];
        if(ind < 0) return 0;
        int pick = nums[ind] + maxSum(nums,ind - 2);
        int notpick = 0+maxSum(nums,ind-1);
        return Math.max(pick,notpick);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        return maxSum(nums,n-1);
    }
}

//memoization
class Solution {
    private int maxSum(int[] nums,int ind,int[] dp){
        if(ind == 0) return nums[0];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + maxSum(nums,ind - 2,dp);
        int notpick = 0+maxSum(nums,ind-1,dp);
        return dp[ind] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum(nums,n-1, dp);
    }
}

//tabulation
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int pick = nums[i]; if(i > 1)pick += dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n-1];
    }
}

class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int pick = nums[i]; if(i > 1)pick += prev2;
            int notpick = prev;
            int curi = Math.max(pick, notpick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}

//rob in Circular House arrangement without adjacent
class RobHouse {
    private int maxSum(int[] arr){
        int prev = arr[0];
        int prev2 = 0;

        for(int i=1; i<arr.length; i++){
            int take = arr[i]; if(i > 1) take += prev2;
            int nottake = prev;
            int curi = Math.max(take,nottake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int [] nums1 = new int[n-1];
        int [] nums2 = new int[n-1];
        int j=0,k=0;
        for(int i=0; i<n; i++){
            if(i!=0) nums1[j++] = nums[i];
            if(i!=n-1) nums2[k++] = nums[i];
        }

        int ans1 = maxSum(nums1);
        int ans2 = maxSum(nums2);

        return Math.max(ans1, ans2);
    }
}
package DynamicProgramming;
import java.util.Arrays;

class UniquePaths {
    public int uniquePathsUtil(int i, int j){
        if(i==0 && j==0)return 1;
        if(i<0 || j<0)return 0;
        int left = uniquePathsUtil(i-1,j);
        int right = uniquePathsUtil(i,j-1);
        return left+right;
    }
    public  int uniquePaths(int m, int n) {
        return uniquePathsUtil(m-1,n-1);
    }
}

//memoization
class Solution {
    public int uniquePathsUtil(int i, int j,int [][] dp){
        if(i==0 && j==0)return 1;
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int left = uniquePathsUtil(i-1,j,dp);
        int right = uniquePathsUtil(i,j-1,dp);
        return dp[i][j] = left+right;
    }
    public  int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[]row: dp){
            Arrays.fill(row,-1);
        }
        return uniquePathsUtil(m-1,n-1,dp);
    }
}

//Tabulation
class Solution2 {
    public  int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0)dp[i][j]=1;
                else{
                    int up=0,left=0;
                    if(i>0) up =dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//Space Optimization
class Solution3{
    public  int uniquePaths(int m, int n) {
        int[]prev = new int[n];
        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0)temp[j] = 1;
                else{
                    int up = 0;
                int left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];
                temp[j] = up + left;
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
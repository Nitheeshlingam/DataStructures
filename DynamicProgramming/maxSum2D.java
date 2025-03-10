package DynamicProgramming;
//recursion

import java.util.Arrays;

public class maxSum2D{
    private int maxPoints(int[][]arr,int day, int last){
        if(day == 0){
            int maxi = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    maxi = Math.max(maxi,arr[0][task]);
                }
            }
            return maxi;
        }
        
        int maxi = 0;
        for(int task = 0; task<3; task++){
            if(task != last){
                int point = arr[day][task]+maxPoints(arr,day-1,task);
                maxi = Math.max(point,maxi);
            }
        }
        return maxi;
    }
    public int maximumPoints(int arr[][]) {
         int n = arr.length;
         return maxPoints(arr,n-1,3);
    }
}

//memoization

class Solution {
    private int maxPoints(int[][]arr,int day, int last, int [][] dp){
        if(dp[day][last] != -1) return dp[day][last];
        if(day == 0){
            int maxi = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    maxi = Math.max(maxi,arr[0][task]);
                }
            }
            return dp[day][last] =  maxi;
        }
        
        int maxi = 0;
        for(int task = 0; task<3; task++){
            if(task != last){
                int point = arr[day][task]+maxPoints(arr,day-1,task,dp);
                maxi = Math.max(point,maxi);
            }
        }
        return dp[day][last]= maxi;
    }
    public int maximumPoints(int arr[][]) {
         int n = arr.length;
         int [][] dp = new int [n][4];
         for(int []  row: dp){
             Arrays.fill(row, -1);
         }
         return maxPoints(arr,n-1,3,dp);
    }
}

//Tabulation
class Solution2 {
    public int maximumPoints(int points[][]) {
        int n =points.length;
        int[][] dp = new int [n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
     
        for(int day = 1; day<n; day++){
            for(int last=0; last<4; last++){
                dp[day][last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task!=last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}

//space optimization

class Solution3{
    public int maximumPoints(int points[][]) {
        int n =points.length;
        int[]prev= new int[4];
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][0],points[0][1]);
        prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
     
        for(int day = 1; day<n; day++){
            int temp[] = new int[4];
            for(int last=0; last<4; last++){
                temp[last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task!=last){
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last],point);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}
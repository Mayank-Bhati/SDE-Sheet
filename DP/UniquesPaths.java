package DP;

import java.util.Arrays;

public class UniquesPaths {

    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the
 bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
     */
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] a : dp)
            Arrays.fill(a,-1);
        dp[m-1][n-1] = 1;
        return util(0,0,m,n,dp);
    }

    private static int util(int i, int j, int m, int n, int[][] dp) {
        if(i >= m || j >= n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        else{
            int ans = 0;
            if(i < m-1)
                ans += util(i+1,j,m,n,dp);
            if(j < n-1)
                ans += util(i,j+1,m,n,dp);
            dp[i][j] = ans;
            return dp[i][j];
        }
    }
}

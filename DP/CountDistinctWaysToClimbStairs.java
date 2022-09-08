package DP;

public class CountDistinctWaysToClimbStairs {

    public static int countWays(int n , int count, int[] dp){

        if(n==0)
            return count;

        if(n==2 || n==1)
            return n;

        if(dp[n] != 0)
            return dp[n];

        dp[n] = countWays(n-1, count, dp) + countWays(n-2, count, dp);
        return dp[n];

    }

    public static void main(String[] args){

        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(countWays(n, 1, dp));

    }


}

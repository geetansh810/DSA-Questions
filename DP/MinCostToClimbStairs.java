package DP;

import java.util.Arrays;

import static java.lang.Math.min;

public class MinCostToClimbStairs {

    public static int solution(int[] cost, int n, int[] dp) {

//        System.out.println(n);

        if (n == 0)
            return cost[0];

        if (n == 1)
            return cost[1];

        if (dp[n] != -1)
            return dp[n];

        dp[n] = cost[n] + min(solution(cost, n - 1, dp), solution(cost, n - 2, dp));
        return dp[n];

    }

    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
//        System.out.println("cost length -> "+n);
        int[] dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }

//        System.out.println("1 -> "+solution(cost, n-1, dp));
//        System.out.println("2 -> "+solution(cost, n-2, dp));

        int ans = min(solution(cost, n - 1, dp), solution(cost, n - 2, dp));

        return ans;


    }

    public static void main(String[] args) {

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println("Minimum cost to climb " + cost.length + " stairs is " + minCostClimbingStairs(cost));

    }

}

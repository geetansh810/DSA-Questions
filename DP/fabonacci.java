package DP;

public class fabonacci {

    public static int fab(int n, int[] dp){

        if(n==1 ){
            return 1;
        }
        if(n==2){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] =  fab(n-1, dp) + fab(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args){

//        0 1 1 2 3 5 8 13

        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(fab(n, dp));

    }


}

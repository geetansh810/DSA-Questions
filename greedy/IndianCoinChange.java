package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class IndianCoinChange {

    public static int minNumOfCoinsReq(int n, int[] coins, int amount){

        ArrayList<Integer> al = new ArrayList<>();

        if(amount <= 0)
            return 0;

        Arrays.sort(coins);
        int ans = 0;

        for(int i=n-1; i>=0; i--){

            int coin = coins[i];

            while(coin <= amount){
                // System.out.println(coin);
                al.add(coin);
                amount -= coin;
                ans++;
            }

        }

        System.out.println(al);

        if(ans == 0 || amount != 0)
            return -1;

        return ans;


    }

    public static void main(String[] args){

        int n = 10;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int amount = 99;

        int minNumber = minNumOfCoinsReq(n, coins, amount);
        System.out.println("Minimum number of coins required = "+minNumber);

    }

}

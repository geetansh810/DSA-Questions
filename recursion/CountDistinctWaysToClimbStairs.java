package recursion;

public class CountDistinctWaysToClimbStairs {

    public static int countWays(int n , int count){

        if(n==0)
            return count;

        if(n==2 || n==1)
            return n;

        return countWays(n-1, count) + countWays(n-2, count);

    }

    public static void main(String[] args){

        int n = 0;
        System.out.println(countWays(n, 1));

    }

}

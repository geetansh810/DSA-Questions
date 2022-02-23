import java.util.*;

public class primeNumber{

     public static void main(String []args){

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        Solution ans = new Solution();

        int mainAns = ans.maxSubArray(nums);
         System.out.println(mainAns);

     }
}

class Solution {
    public int maxSubArray(int[] nums) {

        Scanner sc = new Scanner(System.in);

        int x = nums.length;
        System.out.println("length of arr = " + x);
        int maxSum1 = 0;

        for(int j=0; j<x; j++){

            int currSum = 0;

            for(int k=j; k<x; k++){
                currSum += nums[k];
                System.out.print(nums[k] + " + ");
            }

            System.out.println(" = " +currSum);
            if(currSum>maxSum1){
                maxSum1 = currSum;
            }

            System.out.println("MaxSum1 = "+maxSum1);

        }

        System.out.println("Final max1 = "+maxSum1);

        int maxSum2 = 0;

        for(int j=0; j<x; j++){

            int currSum = 0;

            for(int k=x-j-1; k>=0; k--){
                currSum += nums[k];
                System.out.print(nums[k] + " + ");
            }

            System.out.println(" = " +currSum);

            if(currSum>maxSum2){
                maxSum2 = currSum;
            }

            System.out.println("MaxSum2 = "+maxSum2);


        }

        System.out.println("Final max2 = "+maxSum1);


        return Math.max(maxSum1, maxSum2);

    }
}
package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArrayWithGivenSum {

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here


        ArrayList<Integer> ans = new ArrayList<>();

        if(n == 1 && arr[0]==s){
            ans.add(1);
            ans.add(1);
            return ans;
        }

        if(n < 1){
            ans.add(-1);
            return ans;
        }

        //v----i/j
        int i=0;//2-----1
        int j=0;//2-----1

        int sum  = arr[i];

        while(sum != s && j<n && i<n && i<=j){

            System.out.println("i-> "+i);
            System.out.println("j-> "+j);

//            if(j+1 >= n){
//                j=i;
//                sum = arr[i];
//                continue;
//            }

            if(i+1 >= n){
                ans.add(-1);
                return ans;
            }

            if(j+1 >= n || sum > s){
                ++i;
                j = i;
                sum = arr[i];
                continue;
            }

            ++j;
            sum += arr[j];

        }

        System.out.println(sum);

        if(sum != s){
            System.out.println("------------------");
            ans.add(-1);
            return ans;
        }

        ans.add(i+1);
        ans.add(j+1);
        return ans;


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(subarraySum(arr,n,s));

    }

}

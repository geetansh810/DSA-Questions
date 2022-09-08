package greedy;

import java.util.Arrays;

public class MaxMinDifference {

    public static void main(String[] args) {

        int n = 4;
        int[] arr = {12,-3,10,0};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //max diff = summesion of diff of A[i] - B[i]
        //          = (Sum of first n/2 elements of sorted array) - (Sum of last n/2 elements of sorted array)

        //min diff = summesion of diff of A[i] - B[i]
        //          = (Sum of odd indexed n/2 elements of sorted array) - (Sum of even indexed n/2 elements of sorted array)

        long max = 0;
        long min = 0;

        for(int i=0; i<n/2; i++){

            max += arr[i+n/2] - arr[i];
            min += arr[2*i+1] - arr[2*i];
        }

        System.out.println("Max -> "+max);
        System.out.println("Min -> "+min);

    }

}

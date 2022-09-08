package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;


public class MergeSort {
//works on divide and conquer

    public static void merge(int[] arr, int start, int mid, int end){

        int i = start;
        int j = mid+1;
        int k = 0;

        int[] sorted = new int[end-start+1];

        while(i<=mid && j<=end){

            if(arr[i] <= arr[j]){
                sorted[k] = arr[i];
                i++;
            }else{
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i>mid){
            while(j<=end){
                sorted[k] = arr[j];
                j++;
                k++;
            }
        }else{
            while(i<=mid){
                sorted[k] = arr[i];
                i++;
                k++;
            }
        }

//        System.out.println(Arrays.toString(sorted));
//        System.out.println("Start -> "+start);
//        System.out.println("End -> "+end);

        for (int idx=0, x=start; idx< sorted.length; idx++,x++) {
            arr[x] = sorted[idx];
        }

//        System.out.println("=====================================");
    }

    public static int[] mergeSort(int[] arr, int start, int end){


        if(start < end){
            int mid = start + (end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }

        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sorted = mergeSort(arr, 0, n-1);
        System.out.println(Arrays.toString(sorted));
    }



}

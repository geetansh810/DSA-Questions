package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    public static int partition(int[] arr, int start, int end){

        //pivot as the last element of the array
//        int pivot = arr[end];
//        int i = start-1;
//
//        for(int j=start; j<=end-1; j++){
//
//            if(arr[j] < pivot){
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//
//        }
//
//        i++;
//        int temp = arr[i];
//        arr[i] = pivot;
//        arr[end] = temp;
//        return i;


        //pivot as the starting element of the array
        int pivot = arr[start];
        int i = start+1;
        int j = end;

        while(i<j){
            while(arr[i] <= pivot)
                i++;
            while(arr[j] > pivot)
                j--;

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        int temp = arr[start];
        arr[start] = arr[j];
        arr[j] = temp;
        return j;


        //pivot as the middle element of the array
//        int pivot = arr[(start+end+1)/2];
//        int i = start;
//        int j = end;
//
//        while(i<j){
//            while(arr[i] <= pivot)
//                i++;
//            while(arr[j] > pivot)
//                j--;
//
//            if(i<j){
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//
//        }
//
//        int temp = arr[start];
//        arr[start] = arr[j];
//        arr[j] = temp;
//        return j;


    }

    public static int[] quickSort(int[] arr, int start, int end){

        if(start < end){
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }

        return arr;
    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        int[] A = {9, 5, 2, 100, 65, 33, 0};

//        System.out.println(A.length-1);
        int[] sorted = quickSort(A, 0, 6);
        System.out.println(Arrays.toString(sorted));
    }


}

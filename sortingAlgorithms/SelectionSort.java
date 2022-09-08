package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    public static int[] selectionSort(int[] arr, int n){

        for(int i=0; i<n; i++){

            int min = i;

            for(int j=i+1; j<n; j++){
                    if(arr[min] > arr[j]){
                        min = j;
                    }
            }

            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

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

        int[] sorted = selectionSort(arr, n);
        System.out.println(Arrays.toString(sorted));
    }

}

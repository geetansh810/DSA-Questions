package sortingAlgorithms;
import java.util.*;

public class BubbleSort {

    public static int[] swap(int[] arr, int i){

        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
        return arr;
    }

    public static int[] bubbleSort(int[] arr, int n){

        boolean swapped = false;

        for(int i=0; i<n; i++){

            swapped = false;

            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swapped = true;
                    arr = swap(arr, j);
                }
            }

            if(!swapped)
                break;

        }

        return arr;
    }

    public static void main(String[] args) {
        // Your code goes here

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] sorted = bubbleSort(arr, n);

        for(int num : sorted){
            System.out.print(num + " ");
        }

    }


}

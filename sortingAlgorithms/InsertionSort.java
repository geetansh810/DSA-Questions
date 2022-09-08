package sortingAlgorithms;

import java.util.*;

public class InsertionSort {

    public static int[] insertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
//            System.out.println("temp -> "+temp);
            int j = i - 1;
//            System.out.println("j -> "+j);
            while (j >= 0 && arr[j] > temp) {
//                System.out.println("arr[j] -> "+arr[j]);
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
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

        int[] sorted = insertionSort(arr, n);
        System.out.println(Arrays.toString(sorted));
    }

}

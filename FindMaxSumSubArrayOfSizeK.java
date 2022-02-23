import java.util.Scanner;

public class FindMaxSumSubArrayOfSizeK {

    //Sliding window problem with fixed window size

    //Given an array of integers Arr of size N and a number K.
    // Return the maximum sum of a subarray of size K.

    public static int findMaxSubArray(int[] arr, int n, int k) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;

        while (j != n) {
            sum = sum + arr[j];

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            } else {
                System.out.println("Index out of bound");
            }
        }

        return max;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array -> ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the size of window -> ");
        int k = sc.nextInt();

        int max = findMaxSubArray(arr, n, k);

        System.out.println("Max sum of the sub array of size " + k + " is " + max);

    }

}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Sliding window problem with fixed window size
public class SlidingWindowProblems {

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









    //find the maximum number in the subarray of size k
    public static int[] maxNumber(int[] arr, int n, int k) {

        if(n <=1) return arr;

        //Doubly ended queue for tracking the largest number in the window
        Deque<Integer> maxAd = new LinkedList<>();

        //Array for the max number in each window
        int[] ans = new int[n - k + 1];

        int i;
        for (i = 0; i < n; i++) {

            //for first window
            if (i < k) {
                while (!maxAd.isEmpty() && (arr[i] >= arr[maxAd.peekLast()])) {
                    maxAd.removeLast();
                }
                maxAd.addLast(i);
            }

            //after first window
            else {

                ans[i - k] = arr[maxAd.peekFirst()];

                //for removing the index which is out of the new window
                while (!maxAd.isEmpty() && maxAd.peekFirst() < i - k) {
                    maxAd.removeFirst();
                }

                //for adding largest element index of new window to the deque
                while (!maxAd.isEmpty() && (arr[i] >= arr[maxAd.peekLast()])) {
                    maxAd.removeLast();
                }
                maxAd.addLast(i);

            }

        }

        ans[i - k] = arr[maxAd.peekFirst()];

        return ans;

    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 1, 2, 5, 3, 4, 7, 1, 9};
        System.out.print("Arr : ");
        for (int i :
                arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("<------------------------->");

        int maxSum = findMaxSubArray(arr, arr.length, 4);
        System.out.println("Max sum of the sub array of size 4 is " + maxSum);

        System.out.println("<------------------------->");

        System.out.println("Max number in each window of 4 is :");
        int[] ans = maxNumber(arr, arr.length, 4);
        for (int i :
                ans) {
            System.out.print(i + ", ");
        }
    }

}

package practice;

public class problem2 {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        int k = 2;
        int n = arr.length;

        int[] ans = new int[n];

        int start = n - k - 1;
        int i = 0;

        while (start < n && i<n) {
            ans[i] = arr[start];
            start++;
            i++;
        }

        start = 0;
        while (start < n && i<n) {
            ans[i] = arr[start];
            start++;
            i++;
        }

        for (int num : ans
             ) {
            System.out.println(num);
        }
    }

}

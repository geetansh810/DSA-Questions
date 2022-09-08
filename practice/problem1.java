package practice;

public class problem1 {

    public static void main(String[] args) {

        int[] arr = {100, 21, 5, 6, 3, 7, 11, 89, 10};
        int[] ans = new int[arr.length];
        int j =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 != 0) {
                ans[j] = arr[i];
                arr[i] = -1000;
                j++;
            }
        }

        int idx=0;
        while(idx<arr.length && j<arr.length ){
            if(arr[idx] != -1000){
                ans[j] = arr[idx];
                j++;
            }
            idx++;
        }

        for (int num : ans
        ) {
            System.out.println(num);

        }

    }

}

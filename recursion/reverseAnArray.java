package recursion;

import java.util.Arrays;

public class reverseAnArray {

    public static int[] reverseArray(int[] arr, int start, int last){

        if(start >= last)
            return arr;

        int temp = arr[start];
        arr[start] = arr[last];
        arr[last] = temp;
        return reverseArray(arr, start+1, last-1);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverseArray(arr, 0, arr.length - 1)));
    }



}

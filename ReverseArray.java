public class ReverseArray {

    public static void reverse(int arr[], int start, int end){

        if(start>=end){
            printReverse(arr);
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, ++start, --end);

    }

    public static void printReverse(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args){

        int arr[] = {4, 5, 1, 2, 3};

        reverse(arr,0,arr.length-1);


    }

}

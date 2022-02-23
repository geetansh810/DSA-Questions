public class MinMaxInArray {

    public static void printMinMax(int[] arr, int idx, int min, int max){

        if(idx == arr.length){
            System.out.println("Max = "+max);
            System.out.println("Min = "+min);
            return;
        }

        if(arr[idx]<min){
            min = arr[idx];
        }
        if(arr[idx]>max){
            max = arr[idx];
        }

        idx++;
        printMinMax(arr, idx, min, max);


    }

    public static void main(String[] args){
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        printMinMax(arr, 1, arr[0], arr[0]);
    }


}

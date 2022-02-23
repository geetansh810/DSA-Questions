public class PartitioningArray {

    public static void printArray(int[] arr){

            for (int j=0; j< arr.length; j++) {
                System.out.println(arr[j]);
            }
    }

    public static void partitionAnArray(int[] arr, int minStart, int maxStart, int pivot){


        if(maxStart >= arr.length){
            printArray(arr);
            return;
        }

        if(arr[maxStart] > pivot){
            maxStart++;
            partitionAnArray(arr, minStart, maxStart, pivot);
        }

        if(arr[maxStart] <= pivot){
            int temp = arr[minStart];
            arr[minStart] = arr[maxStart];
            arr[maxStart] = temp;
            minStart++;
            maxStart++;
            partitionAnArray(arr, minStart, maxStart, pivot);
        }



        //while loop approach

//        while(maxStart < arr.length){
//
//            if(arr[maxStart] > pivot){
//                maxStart++;
//            }
//
//            if(arr[maxStart] <= pivot){
//                int temp = arr[minStart];
//                arr[minStart] = arr[maxStart];
//                arr[maxStart] = temp;
//                minStart++;
//                maxStart++;
//            }
//
//        }
//
//        for (int j=0; j< arr.length; j++) {
//            System.out.println(arr[j]);
//        }



    }

    public static void main(String[] args){
        int[] arr = {7,9,4,8,3,6,2,1};
        partitionAnArray(arr, 0,0,5); // = return
        System.out.println("Ended");
    }

}

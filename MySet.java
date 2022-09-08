import java.util.HashSet;
import java.util.Set;

public class MySet {

    //find the subarray who's sum is zero
    public static Boolean subarraySumZero(int[] a) {

        //<------------------------------------------->
        //brute force
//        for (int i=0; i<a.length; i++){
//
//            int sum = 0;
//            for(int j=i; j<a.length; j++){
//                sum += a[j];
//                if(sum == 0){
//                    return true;
//                }
//            }
//        }
//        return false;
        //<------------------------------------------->

        Set<Integer> setOfSums = new HashSet<>();
        int sum = 0;

        for (int element : a
        ) {
            setOfSums.add(sum);
            sum += element;
            if (setOfSums.contains(sum)) {
                return true;
            }
        }
        return false;

    }


    //<------------------------------------------->
    //find the subarray who's sum is K
    public static Boolean subarraySumK(int[] a, int k) {

        Set<Integer> setOfSums = new HashSet<>();
        int sum = 0;

        for (int element : a
        ) {

            sum += element;
            setOfSums.add(sum);
            if (setOfSums.contains(sum - k)) {
                return true;
            }
        }
        return false;

    }
    //<------------------------------------------->


    public static void main(String[] args) {

        int[] a = {3, 4, -1, 4, 3, -6, -7, 2};
//        int[] a = {2, 1, 3, -4, -2};
        System.out.print("Array = ");

        for (int e: a
             ) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Array contains subarray with sum zero = " +subarraySumZero(a));

        System.out.println("Array contains subarray with sum "+6+" = " +subarraySumK(a, 6));

    }

}

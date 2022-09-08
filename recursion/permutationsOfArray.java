package recursion;

import java.util.ArrayList;

public class permutationsOfArray {

    public static void permu(int[] arr, int n){

        for(int i=0; i<n; i++){
            ArrayList<Integer> per = new ArrayList<>();
            int temp = arr[i];
            per.add(temp);

        }

    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        permu(arr , arr.length);
    }


}

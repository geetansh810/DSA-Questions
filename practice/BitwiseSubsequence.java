package practice;

public class BitwiseSubsequence {

    public static void main(String[] args) {

//        int n = 5;
//        int[] arr = {15,6,5,12,1};

//        int n = 6;
//        int[] arr = {9,17,2,15,5,2};

        int n = 7;
        int[] arr = {17,16,12,2,8,17,17};

        int maxLength = 1;
        int currLength = 1;

        int i=0;
        int j=1;

        while(i<j && j<n){


            if( (arr[i]<arr[j]) &&
                    ((arr[i] & arr[j]) * 2) < (arr[i] | arr[j])){
                currLength++;
            }else{
                if(maxLength < currLength){
                    maxLength = currLength;
                }
                currLength = 1;
            }

            i++;
            j++;

        }

        System.out.println(maxLength);

    }

}

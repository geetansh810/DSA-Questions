package practice;

import java.util.Scanner;

public class relevel1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        long count =0;

        for(int i=0; i<n; i++){

            long  a = arr[i];

            if(a != -1){

                for(int j=i+1; j<n; j++){
                    long b= arr[j];

                    if(b != -1){
                        if((float)(a+b)/2 == (float)(a&b)){
                            count++;
                            arr[j] = -1;
                        }
                    }
                }
            }

        }

        System.out.println(count);

    }

}

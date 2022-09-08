package practice;

import java.util.Scanner;

public class CricketPractice {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            int[] l = new int[n];

            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
            }

            int[] r = new int[n];

            for (int i = 0; i < n; i++) {
                r[i] = sc.nextInt();
            }

            int time=0;
            int i=0;
            int j=0;

            while(j<n && i<n && time<=1000000000){

                int start = l[i];
                int end = r[j];

                if(time != start){
                    System.out.println(time + " "+start);
                    j++;
                }

                time = end;
                i++;

            }


        }



    }


}

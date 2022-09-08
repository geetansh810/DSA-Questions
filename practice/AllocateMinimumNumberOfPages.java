package practice;

import java.util.PriorityQueue;

public class AllocateMinimumNumberOfPages {

    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {

        //Your code here
        int low = A[N-1];
        int high = 0;

        for(int i=0; i<N; i++){
            high += A[i];
        }

//        PriorityQueue<Integer> ans = new PriorityQueue<>();
        int ans =0;
        while(low <= high){


            int mid = (low+high)/2;
            int studentsNeed = 1;
            int pages = 0;

            System.out.println();
            System.out.println("low => "+low);
            System.out.println("high => "+high);
            System.out.println("mid => "+mid);
            System.out.println();

            for(int i=0; i<N; i++){
                pages += A[i];
                System.out.println(pages);

                if(pages > mid){
                    System.out.println();
                    studentsNeed++;
                    pages = A[i];
                }

            }

            System.out.println("need -> "+studentsNeed);
            if(studentsNeed <= M){
//                ans.add(mid);
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }


        }

//        ans.add(low);

//        System.out.println(ans);
//        return ans.peek();
            return ans;
    }


    public static void main(String[] args) {

        int N = 11;
        int[] A = {13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85};
        int M = 9;

//        int N = 11;
//        int[] A = {3, 5, 12, 16, 33, 39, 65, 67, 76, 90, 93};
//        int M = 6;

//        int N =16;
//        int[] A = {2, 5, 6, 15, 19, 25, 43, 49, 60, 64, 70, 80, 83, 90, 90, 97};
//        int M = 14;
        System.out.println("ANSWER ------> "+findPages(A,N,M));

    }

}

import java.util.*;

public class BejaminBulb {



        public static void main(String[] args) {
            // write your code here

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            Boolean[] arr = new Boolean[n];
            Arrays.fill(arr, Boolean.TRUE);

            for(int i=2; i<=n; i++){

                for(int j=i; j<=n; j+=i){
                    arr[j-1] = !arr[j-1];
                }

            }

            for(int i=0; i<n; i++){
                if(arr[i]){
                    System.out.print("b"+(i+1)+" ");
                }
            }


        }

}

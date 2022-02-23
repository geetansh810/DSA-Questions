import java.util.*;

public class factorize{

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();

        while(num1>1){
            for(int i=2; i<=num1; i++){
                if(num1%i == 0){
                    num1 = num1/i;
                    System.out.print(i+" ");
                    break;
                }
            }
            System.out.println("num1 = " + num1);
        }

    }
}

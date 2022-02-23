import java.util.*;
public class gcdLcm {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int x = num1;
        int y = num2;

        //gcd
        while(num1%num2 != 0){
            int remainder = num1%num2;
            num1 = num2;
            num2 = remainder;
        }

        int gcd = num2;
        System.out.println(gcd);

        int lcm = (x*y)/gcd;
        System.out.println(lcm);

    }

}

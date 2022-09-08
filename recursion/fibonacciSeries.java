package recursion;

public class fibonacciSeries {

    public static int fab(int n){

        if(n==1 || n ==2)
            return 1;

        int num = fab(n-1) + fab(n-2);
        return num;

    }

    public static void main(String[] args){

        System.out.println("~" +fab(7));

    }


}

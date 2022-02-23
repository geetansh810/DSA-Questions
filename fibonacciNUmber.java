public class fibonacciNUmber {

    public static int fib(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {

            return fib(n - 1) + fib(n - 2);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
    }


}

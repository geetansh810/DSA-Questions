package recursion;

public class factorialOfANumber {

    public static int fact(int n) {

        if (n == 0)
            return 1;

        return n * fact(n - 1);

    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(fact(a));
    }

}

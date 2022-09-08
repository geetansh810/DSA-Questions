package recursion;

public class powerOfANumber {

    //time complexity = O(logN)

    public static int pow(int x, int n){

        if(n==0)
            return 1;

        if(n%2 == 0)
            return pow(x, n/2) * pow(x, n/2);

        return x * pow(x,n/2) * pow(x, n/2);

    }

    public static void main(String[] args){
        System.out.println(pow(5,4));
    }


}

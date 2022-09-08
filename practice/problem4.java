package practice;

public class problem4 {

    public static boolean checkPrime(int n){


        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean checkPair(int start, int end){

        int i = start+1;

        while(i<=end){
            if(start+6 == i && checkPrime(start) && checkPrime(i)){
                System.out.println(start + " -- "+i);
                return true;
            }
            i++;
        }

        return false;

    }

    public static void main(String[] args) {

        int upper = 29;
        int lower = 5;
        int count = 0;

        for(int i=lower; i<=upper-1; i++){
            if(checkPair(i, upper))
                count++;
        }

        System.out.println(count);



    }

}

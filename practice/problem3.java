package practice;

import java.util.*;

public class problem3 {


    public static boolean addDigits(int num){

        Set<Integer> set = new HashSet<>();

        while(num != 0){
            int digit = num%10;
            set.add((digit));
            num = num/10;
        }

        if(set.size() > 1)
            return true;

        return false;

    }

    public static void main(String[] args) {

        int upper = 15;
        int lower = 10;
        int count = 0;

        for(int i=lower; i<=upper; i++){
            if(addDigits(i))
                count++;
        }

        System.out.println(count);


    }
}
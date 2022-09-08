package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DefeatMonster {

    public static int maxMonstersDefeated(int numberOfMonters, int initialPower, int[] power, int[] bonus){

        HashMap<Integer, Integer> eachMonster = new HashMap<>();

        for(int i=0; i<numberOfMonters; i++ ){
            eachMonster.put(power[i], bonus[i]);
        }

        Arrays.sort(power);

        int count =0;

        for(int i=0; i<numberOfMonters; i++){

            int neededPower = power[i];

            if(neededPower > initialPower){
                break;
            }

            initialPower += eachMonster.get(neededPower);
            count++;

        }

        return count;


    }

    public static void main(String[] args){

//        int numberOfMonters = 3;
//        int initialPower = 100;
//        int[] power = {101,100,304};
//        int[] bonus = {100, 1, 524};

        int numberOfMonters = 2;
        int initialPower = 123;
        int[] power = {78, 130};
        int[] bonus = {10, 0 };

        int maxMonsters = maxMonstersDefeated(numberOfMonters, initialPower, power, bonus);
        System.out.println(maxMonsters);

    }


}

package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Expedia {

    public static int minNoStops(int[][] distanceWithFuelAvailable, int n, int distance, int initialFuel){


        for (int i = 0; i < n; i++) {
            distanceWithFuelAvailable[i][0] = distance - distanceWithFuelAvailable[i][0];
        }

        Arrays.sort(distanceWithFuelAvailable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        System.out.println(Arrays.deepToString(distanceWithFuelAvailable));

        int currentFuel = initialFuel;
        int stops = 0;

        PriorityQueue<Integer> fuelAvailable = new PriorityQueue<>(Collections.reverseOrder());

        boolean flag = false;

        for (int i = 0; i < n; i++) {

            if(currentFuel > distance)
                break;

            //checks weather current fuel is enough to reach next stop
//            System.out.println("Current fuel available -> "+currentFuel);
//            System.out.println("Distance to next stop -> "+distanceWithFuelAvailable[i][0]);
//            System.out.println();

            while(currentFuel < distanceWithFuelAvailable[i][0]){

                if(fuelAvailable.size() == 0){
                    flag = true;
                    break;
                }

                stops++;
//                System.out.println(stops);
//                System.out.println(fuelAvailable.toString());
//                System.out.println("Fuel added to current-> "+fuelAvailable.peek());
//                System.out.println();
//                System.out.println(fuelAvailable.toString());
                currentFuel += fuelAvailable.poll();

            }

            if(flag)
                break;

//            System.out.println("Fuel added to bank-> "+distanceWithFuelAvailable[i][1]);
//            System.out.println();
            fuelAvailable.offer(distanceWithFuelAvailable[i][1]);

        }

        if(flag)
            return -1;

//        System.out.println("Fuel available -> "+currentFuel);
//        System.out.println();
        while(fuelAvailable.size() > 0 && currentFuel < distance){
//            System.out.println(fuelAvailable.peek());
            currentFuel += fuelAvailable.poll();
            stops++;
//            System.out.println(stops);
        }

        if(currentFuel < distance)
            return -1;

        return stops;

    }
    public static void main(String[] args) {
//        int n = 4;
//        int[][] distanceWithFuelAvailable = {{4,4},{5,2},{11,5},{15,10}};
//        int distance = 25;
//        int initialFuel = 10;

        int n = 4;
        int[][] distanceWithFuelAvailable = {{10,60},{20,30},{30,30},{60,40}};
        int distance = 100;
        int initialFuel = 10;


        int stops = minNoStops(distanceWithFuelAvailable, n, distance, initialFuel);
        System.out.println();
        System.out.println("Number of stops required -> "+stops);

    }

}

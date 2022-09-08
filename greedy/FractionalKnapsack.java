package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static int getMaxValue(int[][] items, int n, int w) {

        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] item1, int[] item2) {
                return -(item1[0] / item1[1] - item2[0] / item2[1]);
            }
        });

        System.out.println(Arrays.deepToString(items));

        int value =0;

        for(int i=0; i<n; i++){

            if(items[i][1] <= w){
                value += items[i][0];
                w -= items[i][1];
                System.out.println("Weight -> "+items[i][1]+" value -> "+items[i][0]);
                continue;
            }

            value += (items[i][0]/items[i][1]) * w;
            System.out.println("Weight -> "+w+" value -> "+(items[i][0]/items[i][1]) * w);
            break;
        }

        return value;

    }

    public static void main(String[] args) {

//        int noOfItems = 5;
//        int[][] items = {{21, 7}, {24, 4}, {12, 6}, {40, 5}, {30, 6}};
//        int maxWeight = 20;

        int noOfItems = 5;
//        int[][] items = {{10, 10}, {10, 20}, {40, 20}, {50, 50}, {90, 150}};
        int[][] items = {{10, 10}, {20, 10}, {20, 40}, {50, 50}, {150, 90}};
        int maxWeight = 105;


        int maxValue = getMaxValue(items, noOfItems, maxWeight);
        System.out.println(maxValue);

    }

}

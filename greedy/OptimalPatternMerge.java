package greedy;

import java.util.PriorityQueue;

public class OptimalPatternMerge {

    public static void main(String[] args) {

        int[] executionTimes = {5,2,4,7};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<executionTimes.length; i++){
            pq.add(executionTimes[i]);
        }

        int cost =0;

        while(pq.size() > 1){

            int e1 = pq.poll();
            int e2 = pq.poll();
                int temp = e1+e2;
            pq.add(temp);
            cost += temp;

        }

        System.out.println(cost);
    }

}

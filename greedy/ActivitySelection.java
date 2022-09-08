package greedy;

import java.util.Arrays;
import java.util.Comparator;

//public class sortByEndTime implements Comparator<ActivitySelection>{
//
//    public int compare(int end1, int end2){
//        return end1-end2;
//    }
//}

public class ActivitySelection {


    public static int activitySelection(int[][] activities, int n){

        Arrays.sort(activities, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int take = 1;
        int end = activities[0][1];
        System.out.println("Start -> "+activities[0][0]+" End -> "+ end);

        for(int i=1; i<n; i++){
            if(end <= activities[i][0]){
                take++;
                end = activities[i][1];
                System.out.println("Start -> "+activities[i][0]+" End -> "+ end);
            }
        }

        return take;

    }

    public static void main(String[] args) {

        int noOfActivities = 3;
        int[][] activity = {{10,20},{12,15},{20,30}};
        int maxActivity = activitySelection(activity, noOfActivities);
        System.out.println(maxActivity);
    }

}

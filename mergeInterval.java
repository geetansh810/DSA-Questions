import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}


public class mergeInterval {

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if (intervals == null) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int i = 0;
        while (i < intervals.size()) {

            Interval currentInterval = intervals.get(i);

            if (newInterval.start > currentInterval.end) {
                i++;
            } else if (newInterval.end < currentInterval.start) {
                intervals.add(i, newInterval);
                break;
            } else {
                newInterval.start = Math.min(newInterval.start, currentInterval.start);
                newInterval.end = Math.max(newInterval.end, currentInterval.end);
                intervals.remove(i);
            }

        }

        if (i == intervals.size()) {
            intervals.add(newInterval);
        }

        return intervals;

    }

    public static void main(String[] Args) {
        List<Integer> ll = new LinkedList<>();

        ll.add(1, 12);

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(4, 9);

        ArrayList<Interval> newIntervals = insert(intervals, newInterval);

        for (Interval interval : newIntervals) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
    }

}

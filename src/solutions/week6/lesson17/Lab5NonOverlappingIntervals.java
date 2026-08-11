package solutions.week6.lesson17;

import java.util.Arrays;
import java.util.Comparator;

public class Lab5NonOverlappingIntervals {

    public static int minimumIntervalsToRemove(
            int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Greedy choice: sort by ending time
        Arrays.sort(
                intervals,
                Comparator.comparingInt(
                        interval -> interval[1]
                )
        );

        int removedCount = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart < previousEnd) {
                // Overlapping interval: remove it
                removedCount++;
            } else {
                // Keep the current interval
                previousEnd = currentEnd;
            }
        }

        return removedCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        int result =
                minimumIntervalsToRemove(intervals);

        System.out.println(
                "Minimum intervals to remove: " + result
        );
    }
}
package ca.qc.vc.week6.lesson17;

import java.util.*;

public class GAActivitySelection {
    public static List<int[]> selectActivities(int[][] activities) {
        Arrays.sort(
                activities,
                Comparator.comparingInt(a -> a[1])
        );

        List<int[]> selected = new ArrayList<>();
        int lastFinish = Integer.MIN_VALUE;

        for (int[] activity : activities) {
            if (activity[0] >= lastFinish) {
                selected.add(activity);
                lastFinish = activity[1];
            }
        }

        return selected;
    }
    public static void main(String[] args) {
        int[][] activities = {
                {1, 3}, {2, 5}, {4, 6},
                {6, 7}, {5, 9}, {8, 10}
        };

        List<int[]> selected = selectActivities(activities);

        for (int[] activity : selected) {
            System.out.println(Arrays.toString(activity));
        }
    }
}

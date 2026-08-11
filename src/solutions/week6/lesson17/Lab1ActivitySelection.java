package solutions.week6.lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lab1ActivitySelection {

    static class Activity {
        String name;
        int startTime;
        int finishTime;

        Activity(String name, int startTime, int finishTime) {
            this.name = name;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return name + " [" + startTime + ", " + finishTime + "]";
        }
    }

    public static List<Activity> selectActivities(
            Activity[] activities) {

        List<Activity> selected = new ArrayList<>();

        if (activities == null || activities.length == 0) {
            return selected;
        }

        // Greedy choice: sort by finish time
        Arrays.sort(
                activities,
                Comparator.comparingInt(
                        activity -> activity.finishTime
                )
        );

        selected.add(activities[0]);
        int lastFinishTime = activities[0].finishTime;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].startTime >= lastFinishTime) {
                selected.add(activities[i]);
                lastFinishTime = activities[i].finishTime;
            }
        }

        return selected;
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity("A1", 1, 2),
                new Activity("A2", 3, 4),
                new Activity("A3", 0, 6),
                new Activity("A4", 5, 7),
                new Activity("A5", 8, 9),
                new Activity("A6", 5, 9)
        };

        List<Activity> selected =
                selectActivities(activities);

        System.out.println("Selected activities:");

        for (Activity activity : selected) {
            System.out.println(activity);
        }

        System.out.println(
                "Maximum number: " + selected.size()
        );
    }
}
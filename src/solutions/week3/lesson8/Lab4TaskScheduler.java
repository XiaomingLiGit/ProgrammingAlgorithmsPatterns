package solutions.week3.lesson8;

import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
    private String name;
    private int priority;
    private int submissionOrder;

    public Task(String name, int priority, int submissionOrder) {
        this.name = name;
        this.priority = priority;
        this.submissionOrder = submissionOrder;
    }

    public int getPriority() {
        return priority;
    }

    public int getSubmissionOrder() {
        return submissionOrder;
    }

    @Override
    public String toString() {
        return "Task{name='" + name +
                "', priority=" + priority +
                ", order=" + submissionOrder + "}";
    }
}

public class Lab4TaskScheduler {
    public static void main(String[] args) {
        Comparator<Task> taskComparator = Comparator
                .comparingInt(Task::getPriority)
                .thenComparingInt(Task::getSubmissionOrder);

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(taskComparator);

        taskQueue.offer(new Task("Fix login bug", 1, 1));
        taskQueue.offer(new Task("Write report", 3, 2));
        taskQueue.offer(new Task("Backup database", 2, 3));
        taskQueue.offer(new Task("Reply emails", 4, 4));
        taskQueue.offer(new Task("Deploy release", 1, 5));
        taskQueue.offer(new Task("Code review", 2, 6));

        System.out.println("Task at the head using peek():");
        System.out.println(taskQueue.peek());

        System.out.println("\nProcessing tasks:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println(task);
        }
    }
}
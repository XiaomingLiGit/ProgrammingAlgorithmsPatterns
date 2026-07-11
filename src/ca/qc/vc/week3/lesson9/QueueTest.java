package ca.qc.vc.week3.lesson9;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();

        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}

package solutions.week3.lesson8;

import java.util.ArrayDeque;

public class Lab3CustomerServiceQueue {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");
        queue.offer("David");
        System.out.println("Initial queue: " + queue);

        System.out.println("Next customer using peek(): " + queue.peek());
        System.out.println("Queue after peek(): " + queue);

        System.out.println("Processed customer using poll(): " + queue.poll());
        System.out.println("Queue after poll(): " + queue);

        queue.offerFirst("VIP-Customer");
        System.out.println("After offerFirst(): " + queue);

        queue.offerLast("Eve");
        System.out.println("After offerLast(): " + queue);

        System.out.println("First customer: " + queue.peekFirst());
        System.out.println("Last customer: " + queue.peekLast());

        System.out.println("\nProcessing all customers:");
        while (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println("Processed: " + customer);
            System.out.println("Current queue: " + queue);
        }

        System.out.println("\nQueue is now empty.");
        System.out.println("peek() on empty queue: " + queue.peek());
        System.out.println("poll() on empty queue: " + queue.poll());
    }
}
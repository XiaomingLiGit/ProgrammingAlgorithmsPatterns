package ca.qc.vc.week3.lesson9;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        numbers.offer(30);
        numbers.offer(10);
        numbers.offer(20);

        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }
    }
}

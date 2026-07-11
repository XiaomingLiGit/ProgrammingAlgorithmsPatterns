package ca.qc.vc.week3.lesson9;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        deque.addFirst("Alice");
        deque.addLast("Bob");

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
    }
}

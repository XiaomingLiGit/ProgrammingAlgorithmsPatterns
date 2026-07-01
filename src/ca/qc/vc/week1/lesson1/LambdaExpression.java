package ca.qc.vc.week1.lesson1;

import java.util.ArrayList;
import java.util.Comparator;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaExpression {

    public static void main(String[] args) {
        Example.example1();
        Example.lambdaWithoutParameters();
        Example.lambdaWithOneParameter();
        Example.lambdaWithMultipleParameters();
        Example.lambdaWithBlockBody();
    }
}

class Example {

    public static void example1() {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Jerry");
        names.add("Spike");

        // usage before Java 8
        for (String name : names) {
            System.out.println(name);
        }

        // using lambda expression: () -> {}
        names.forEach((String name) -> System.out.println(name));
    }

    public static void lambdaWithoutParameters() {
        Runnable runnable = () -> System.out.println("Hello, World!");
        runnable.run();
    }

    public static void lambdaWithOneParameter() {
        Greeting greeting =
                (String name) -> System.out.println("Hello, " + name + "!");
        greeting.sayHello("Alice");
    }

    public static void lambdaWithMultipleParameters() {
        Comparator<Integer> comparator =
                (Integer a, Integer b) -> a.compareTo(b);

        System.out.println(comparator.compare(5, 3)); // Output: 1
    }

    public static void lambdaWithBlockBody() {
        Greeting greeting = (String name) -> {
            String message = "Hello, " + name + "!";
            System.out.println(message);
        };

        greeting.sayHello("Bob");
    }
}

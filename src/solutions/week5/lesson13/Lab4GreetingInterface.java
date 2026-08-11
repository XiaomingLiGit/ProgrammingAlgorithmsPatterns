package solutions.week5.lesson13;

import java.util.Locale;

@FunctionalInterface
interface Greeting {

    void greet(String name);
}

public class Lab4GreetingInterface {

    public static void main(String[] args) {

        Greeting simpleGreeting =
                name -> System.out.println(
                        "Hello, " + name
                );

        Greeting morningGreeting =
                name -> System.out.println(
                        "Good morning, " + name
                );

        Greeting uppercaseGreeting =
                name -> System.out.println(
                        name.toUpperCase(Locale.ROOT)
                );

        simpleGreeting.greet("Alice");
        morningGreeting.greet("David");
        uppercaseGreeting.greet("Charlotte");
    }
}
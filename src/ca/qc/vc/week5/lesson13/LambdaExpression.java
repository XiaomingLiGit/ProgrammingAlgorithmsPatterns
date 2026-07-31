package ca.qc.vc.week5.lesson13;


import java.util.function.Function;

@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}



public class LambdaExpression {
    public static void main(String[] args) {

        Runnable task = () -> System.out.println("Hello");

        task.run();


        fn1();
        fn2();
    }

    static void fn1(){
        Function<Integer, Integer> square = x ->  x * x;

        System.out.println(square.apply(5));
    }

    static void fn2(){
        Operation add = (a, b) -> a + b;
        System.out.println(add.apply(3, 4));

    }
}

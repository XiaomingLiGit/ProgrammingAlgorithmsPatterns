package ca.qc.vc.week5.lesson13;

import java.util.function.Function;

public class LambdaExpressionDemo {
    // with Lambda Expression
    static void noParameter(){
        Runnable task = () -> {System.out.println("Starting"); System.out.println("Running");};
        task.run();
    }
    // without Lambda Expression
    static void noParameter_0(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting");
                System.out.println("Running");
            }
        };
        task.run();
    }

    // with Lambda Expression
    static void oneParameter(){
        Function<Integer, Integer> square = x -> x * x;
//        Function<Integer, Integer> square = (x) -> {return x * x;};
        System.out.println(square.apply(5));
    }

    // without Lambda Expression
    static void oneParameter_1(){
        Function<Integer, Integer> square =
                new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer a){
                    return a * a;
            }
        };
    }

    public static void main(String[] args) {
        noParameter();
        oneParameter();
    }
}

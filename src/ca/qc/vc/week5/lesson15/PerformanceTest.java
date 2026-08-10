package ca.qc.vc.week5.lesson15;

public class PerformanceTest {
    public static void main(String[] args) {
        getTime(1_000_000);
        getTime(10_000_000);
        getTime(100_000_000);
        getTime(1_000_000_000);
        getTime(10_000_000_000L);
    }

    public static void getTime(long n) {
        long startTime = System.currentTimeMillis();
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time for n = " + n
                + " is " + (endTime - startTime) + " milliseconds");
    }
}
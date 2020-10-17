package es.enjoybahia.task.fibonacci.algorithm;

public class Fibonacci {
    public static long compute(final long n) {
        return n < 2 ? n : compute(n - 1) + compute(n - 2);
    }
}

package _27_01_2023.fib;

import lombok.var;

public class Fibonacci {
    static int count = 0;
    static int maxIndex = 0;

    //0 1 2 3 5 8 13 21 34 55 89

    public static long fibLoops(final int fibIndex) throws IllegalAccessException {
        if (fibIndex < 0) {
            throw new IllegalAccessException();
        }

        var fib1 = -1L;
        var fib2 = 1L;

        for (int i = 0; i <= fibIndex; i++) {
            var fibCurrent = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibCurrent;
        }
        return fib2;
    }

    public static long fibRecursiveVlad(int fibIndex) throws IllegalAccessException {

        if (fibIndex < 0) {
            throw new IllegalAccessException();
        }

        if (fibIndex == 0) {
            return 0;
        }
        maxIndex = fibIndex;

        var fib1 = -1L;
        var fib2 = 1L;

        fib2 = fibIndex;
        fibIndex = (int) (fibIndex + fib2);

        if (count == fibIndex) {

        }
        fibRecursive(fibIndex);

        return 0;
    }

    public static long fibRecursive(final int fibIndex) {
        if (fibIndex < 0) {
            throw new IllegalArgumentException();
        }
        if (fibIndex == 0) {
            return 0;
        }
        return fibIndex == 1 || fibIndex == 2 ? 1L
                : fibRecursive(fibIndex - 2) + fibRecursive(fibIndex - 1);
    }
}
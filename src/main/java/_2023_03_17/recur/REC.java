package _2023_03_17.recur;

import java.util.stream.Stream;

public class REC {
    public static long fibLogs(final int fibIndex) {
        if (fibIndex < 0) {
            throw new IllegalArgumentException();
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

    public static long fibStreamApi(final int fibIndex) {
        var result =
                Stream.iterate(new long[]{0, 1}, arr ->
                        new long[]{arr[1], arr[0] + arr[1]})
                        .limit(fibIndex + 1)
                        .map(y -> y[0])
                        .max(Long::compareTo);
        return result.orElseThrow(IllegalArgumentException::new);
    }

    //0 1 2 3 5 8 13 21 34 55 --> idx 4: value 3
    public static long fibRec(final int fibIndex) {
        if (fibIndex < 0) {
            throw new IllegalArgumentException();
        }
        if (fibIndex == 0) {
            return 0;
        }
        return fibIndex == 1 || fibIndex == 2 ?
                1L : fibRec(fibIndex-2) + fibRec(fibIndex - 1);
    }
}
package _27_01_2023.fib;

//0 1 2 3 5 8 13 21 34 55 89
public class FibonacciTest {
    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        int n = 45;
        long loopStartTime = System.currentTimeMillis();
        System.out.println("Loop number: " + Fibonacci.fibLoops(n));
        System.out.println("Loop time is: " + (System.currentTimeMillis() - loopStartTime));


        long recStartTime = System.currentTimeMillis();
        System.out.println("Recurs: " + Fibonacci.fibRecursive(n));
        System.out.println("Recurs time is: " + (System.currentTimeMillis() - recStartTime));

    }
}

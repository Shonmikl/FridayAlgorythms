package _20_01_2023;

public class BreakPoint {
    private static String get() {
        return "!!!";
    }
    public static void main(String[] args) {
        int a = 0;
        while (a < 3) {
            a++;
        }
        System.out.println(get());
    }
}

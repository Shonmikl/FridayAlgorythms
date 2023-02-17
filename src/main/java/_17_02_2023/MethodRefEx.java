package _17_02_2023;

public class MethodRefEx {
    public static void main(String[] args) {
        m1(MethodRefEx::mr);
    }

    public static void mr() {
        System.out.println("^^^^");
        System.out.println("@@@@");
        System.out.println("####");
    }

    public static void m1(I inter) {
        System.out.println("!!!!");
        inter.go();
    }
}

@FunctionalInterface
interface I {
    void go();
}
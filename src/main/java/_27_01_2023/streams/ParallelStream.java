package _27_01_2023.streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
    static Random random = new Random();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        long fillTime = System.currentTimeMillis();
        for (int i = 0; i < 110_000_000; i++) {
            list.add(random.nextInt(11));
        }
        System.out.println("Fill time: " + (System.currentTimeMillis() - fillTime));

        long time = System.currentTimeMillis();

        double sum = list.stream().reduce(Integer::sum).get();

        System.out.println("Time: " + (System.currentTimeMillis() - time));
        System.out.println(sum);
    }
}
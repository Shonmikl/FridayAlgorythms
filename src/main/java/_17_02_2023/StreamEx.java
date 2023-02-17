package _17_02_2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamEx {

    boolean filter(Integer i) {
        return i % 2 == 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 15; i++) {
            list.add(new Random().nextInt(22));
        }

        //   System.out.println(list);

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 == 0) {
//                System.out.println(list.get(i));
//            }
//        }

//        for (Integer a : list) {
//            System.out.println(a);
//        }

//        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
//        Arrays.stream(args)

        //1,2,3,4,5,6
    }
}

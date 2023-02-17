package _17_02_2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WAP {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("wap.txt")));
        List<String> words = Arrays.asList(contents.split("\\P{L}+"));

        long count = words.stream().distinct().count();
        long countWithRepeat = words.size();

        System.out.println("All words count: " + countWithRepeat);
        System.out.println("Unique words count: " + count);

       words.stream()
                .collect(Collectors.toMap(s -> s, n -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .forEach(word -> System.out.println(word.getKey() + " : " + word.getValue()));
    }
}
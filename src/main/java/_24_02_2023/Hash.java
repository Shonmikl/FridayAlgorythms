package _24_02_2023;

import java.util.HashMap;
import java.util.Map;

public class Hash {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        thread.start();

        Hash hash = new Hash();

        synchronized (hash) {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "QQQ");
            map.put(22, "POI");
            map.put(24, "P*&^");
            map.put(null, "P*&^");
            System.out.println(map);
        }
    }
}

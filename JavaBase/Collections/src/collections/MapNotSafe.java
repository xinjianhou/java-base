package collections;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapNotSafe {

    public static void main(String[] args) {
        Map<String, String> m1 =
                //new HashMap<>();
        //Collections.synchronizedMap(new HashMap<>());
        new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {

            new Thread(() -> {
                m1.put(UUID.randomUUID().toString().substring(0, 8), "hello");
                System.out.println(m1);
            }).start();
        }
    }
}

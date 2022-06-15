package collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetNotSafe {
    public static void main(String[] args) {
        Set<String> s1 =
                //new HashSet<>();
               // Collections.synchronizedSet(new HashSet<>());
        new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                s1.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(s1);
            }).start();


        }
        //java.util.ConcurrentModificationException
    }
}

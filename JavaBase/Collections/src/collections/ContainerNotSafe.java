package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafe {

    public static void main(String[] args) {
        List<String> s1 =
       // Collections.synchronizedList(new ArrayList<>());
        new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {

            new Thread(()->{
                s1.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(s1);
            }).start();
    //java.util.ConcurrentModificationException

        }
    }
}
//可以换vector
//Collections Collections.synchronizedList(new ArrayList<>(s1));
//CopyOnWriteArrayList<>()

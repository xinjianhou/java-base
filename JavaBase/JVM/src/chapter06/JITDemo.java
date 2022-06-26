package chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JITDemo {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add("hello the damn world!");
            try {
                TimeUnit.SECONDS.sleep(1l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

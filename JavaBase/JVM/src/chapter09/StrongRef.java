package chapter09;

import java.util.concurrent.TimeUnit;

public class StrongRef {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello world!");
        StringBuffer sb1 = sb;


        sb = null;
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(3l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb);
        System.out.println(sb1);
    }
}

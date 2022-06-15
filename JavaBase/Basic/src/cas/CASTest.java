package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS compare and swap
 * 比较和交换
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        System.out.println(ai.compareAndSet(1, 1024) + " current value is " + ai);
        System.out.println(ai.compareAndSet(1, 2022) + " current value is " + ai);


    }
}

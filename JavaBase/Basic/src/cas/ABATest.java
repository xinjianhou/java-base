package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest {

    public static void main(String[] args) {

        AtomicReference<Integer> ai = new AtomicReference<>(100);
        AtomicStampedReference<Integer> asi = new AtomicStampedReference<>(100, 1);


        new Thread(() -> {
            ai.compareAndSet(100, 101);
            System.out.println(Thread.currentThread().getName() + " changed to " + ai.get());
            ai.compareAndSet(101, 100);
            System.out.println(Thread.currentThread().getName() + " changed to " + ai.get());

        }, "t1").start();

        new Thread(() -> {
            // sleep 1 second to make sure t1 finished changed twice
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            System.out.println(Thread.currentThread().getName() + " " + ai.compareAndSet(100, 101) + " changed to " + ai.get());

        }, "t2").start();


        new Thread(() -> {

            // sleep 3 second to make sure t1 and t2 finished changed twice
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            asi.compareAndSet(100, 101, 1, 2);
            System.out.println(Thread.currentThread().getName() + " changed to " + ai.get());
            asi.compareAndSet(101, 100, 2, 3);
            System.out.println(Thread.currentThread().getName() + " changed to " + ai.get());

        }, "t3").start();
        new Thread(() -> {
            //first time stamp
            int stamp = asi.getStamp();

            System.out.println("fist time stamp is: " + stamp);

            // sleep 4 second to make sure t3  finished changed twice
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ;
            System.out.println(Thread.currentThread().getName() + " "
                    + asi.compareAndSet(100, 101, stamp, 2) + " last value: " + ai.get() + " last stamp; " + asi.getStamp());


        }, "t4").start();
    }


}

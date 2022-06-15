package blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {

            for (int i = 0; i < 3; i++) {

                try {
                    System.out.println(Thread.currentThread().getName() + "\tput " + i);
                    blockingQueue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }, "t1").start();

        new Thread(() -> {

            for (int i = 0; i < 3; i++) {

                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\tget " + blockingQueue.take());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }, "t2").start();

    }
}

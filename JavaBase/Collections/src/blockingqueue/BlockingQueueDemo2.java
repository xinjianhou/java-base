package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo2 {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        try {
            queue.put("s");
            queue.put("b");
            queue.put("2");
            queue.offer("5", 3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(queue.take());

            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.poll( 3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

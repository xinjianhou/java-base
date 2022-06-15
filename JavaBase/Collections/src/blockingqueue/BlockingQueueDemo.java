package blockingqueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue 基于数组结构的有界阻塞队列，先进先出的原则排序。
 * linkedBlockingQueue 基于链表结构的阻塞队列，先进先出吞吐量高于上着。
 * SynchronousQueue 一个不存储元素的阻塞队列。插入操作要等另一个线程的移除操作，否则一直阻塞。
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("3");
        try {
            queue.put("4");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(queue.offer("5"));

        //exception
        //queue.add("3");

//        try {
//
//            queue.put("4");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //wait()
        //queue.offer("5");
        try {
            System.out.println(queue.offer("6", 3, TimeUnit.SECONDS));;
        } catch (InterruptedException e) {
            throw new Exception(e);
        }
    }


}

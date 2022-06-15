package juc;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {

    private volatile boolean FLAG = false;
    private AtomicInteger ai = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod() throws Exception {
        String data = null;
        boolean reValue = false;
        while (FLAG) {

            data = String.valueOf(ai.incrementAndGet());
            reValue = this.blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (reValue) {
                System.out.println(Thread.currentThread().getName() + "\t插入队列 " + data + " Success");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列 " + data + " Failed");
            }
            try{ TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e){ e.printStackTrace(); }

        }
        System.out.println(Thread.currentThread().getName() + "\tstopped produce");
    }

    public void consumer() throws Exception {

        String result = null;
        while (FLAG) {

            result = this.blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == result || result.isEmpty()){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t取出队列 Failed");
                return;
            }else{
                System.out.println(Thread.currentThread().getName() + "\t取出队列 " + result + " Success");
            }



        }
    }

    public void start() {
        this.FLAG = true;
    }
    public void stop() {
        this.FLAG = false;
    }
}

public class ProdAndConsumer_BlockQueueDemo {

    public static void main(String[] args) {

        MyResource resource = new MyResource(new ArrayBlockingQueue<String>(1));

        resource.start();

        new Thread(() -> {
            try {
                resource.prod();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "PROD").start();

        new Thread(() -> {
            try {
                resource.consumer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "PROD").start();


        try{ TimeUnit.SECONDS.sleep(10); }catch(InterruptedException e){ e.printStackTrace(); }
        resource.stop();

    }


}

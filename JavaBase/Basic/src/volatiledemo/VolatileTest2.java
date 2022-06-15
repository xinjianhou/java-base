package volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

class MyData2 {
    int i = 0;
    //volatile int i = 0;

    public void changeTo60() {
        this.i = 60;
    }

    public void selfPlus() {
        i++;
    }
    AtomicInteger ai = new AtomicInteger();
    public void addAtomic(){
        ai.getAndIncrement();
    }
}

/**
 * 验证volatile的非原子性
 */
public class VolatileTest2 {
    public static void main(String[] args) {

        MyData2 data = new MyData2();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                     data.selfPlus();;
                     data.addAtomic();
                }

            }, String.valueOf(i)).start();

        }

//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(Thread.activeCount());

        if (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "final: "+ data.i +" AI; "+data.ai );
    }
}

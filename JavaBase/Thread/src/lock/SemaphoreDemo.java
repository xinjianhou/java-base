package lock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟三个停车位

        for(int i=0; i<10; i++){//十辆车抢车位
            new Thread(() -> {
                try {
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() +"\t抢到了车位。");
                   // System.out.println(new Random(10).nextInt(15));
                    TimeUnit.SECONDS.sleep(new Random(10).nextInt(10));


                    System.out.println(Thread.currentThread().getName() +"\t离开了车位。");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }

    }
}

package lock;

import enums.Country;

import java.util.concurrent.CountDownLatch;

/**
 * 各线程都先结束自己的，主线程await()
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        //closeDoors();

        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 1; i < 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "第" + finalI + "个被灭了");
                latch.countDown();
                System.out.println("lets go");
            }, Country.getByCode(i).getName()).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("秦统一天下！！ ");
        }
    }

    private static void closeDoors() {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 结束了");
                latch.countDown();
            }, "i").start();
        }
        try {
            //等待结束
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " 放狗");
        }
    }
}

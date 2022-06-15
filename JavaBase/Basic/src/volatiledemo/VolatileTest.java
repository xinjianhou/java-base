package volatiledemo;

import java.util.concurrent.TimeUnit;

class MyData {
     int i = 0;
     //volatile int i = 0;

    public void changeTo60() {
        this.i = 60;
    }
}

/**
 * 验证volatile的可见行
 */
public class VolatileTest {
    public static void main(String[] args) {

        MyData2 data = new MyData2();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " coming in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            data.changeTo60();
            System.out.println(Thread.currentThread().getName() + " updated i into "+data.i);

        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " coming in " +data.i);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " coming before process " +data.i);
            data.changeTo60();
            System.out.println(Thread.currentThread().getName() + " updated i into "+data.i);

        }).start();

        while(data.i == 0) {

        }
        System.out.println(Thread.currentThread().getName() + " game over!");
    }
}

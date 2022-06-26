package chapter08;

import java.util.concurrent.TimeUnit;

public class CanReliveDemo {
    public static Object ref = null;
    private static byte[] heap = new byte[10 * 1024 * 1024];

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Override the finalize method!!!");
        ref = this;
    }

    public static void main(String[] args) {


        try {
            ref = new CanReliveDemo();
            ref = null;
            System.out.println("first time call GC!");
            TimeUnit.SECONDS.sleep(10L);//open jvisualvm check the finalizer thread;
            System.gc();
            TimeUnit.SECONDS.sleep(2l);
            if (null == ref) {
                System.out.println("ref is dead!!!!!");
            } else {
                System.out.println("ref still alive!!!!");
                System.out.println("second time call GC!");
                ref = null;
                System.gc();
                TimeUnit.SECONDS.sleep(2l);
                if (null == ref) {
                    System.out.println("ref is dead!!!!!");
                } else {
                    System.out.println("ref still alive!!!!");
                }
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

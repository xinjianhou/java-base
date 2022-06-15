package chapter02;

public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "\t开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "\t结束了");
        };

        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");

        t1.start();
        t2.start();
    }


}

class DeadThread {
    static {

        if (true) {
            System.out.println(Thread.currentThread().getName() + "\t加载了类");
            while (true) {

            }
        }
    }
}

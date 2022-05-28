package runnable;

class Clerk {
    private int product = 0;

    public synchronized void consume() {

        notify();
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + ":消费第" + product + "个产品！");
            product--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void produce() {

        notify();
        if (product < 20) {

            product++;
            System.out.println(Thread.currentThread().getName() + ":生产第" + product + "个产品！");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Producer implements Runnable {
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.produce();
        }
    }
}

class Customer implements Runnable {

    Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consume();
        }
    }
}


public class ThreadTest {

    public static void main(String[] args) {
        Clerk c = new Clerk();
        // 保证synchronized，wait和notify的对象是一样的才有效，这里使用的是clerk对象，肯定是唯一的。
        Producer p1 = new Producer(c);
        Customer c1 = new Customer(c);
        Customer c2 = new Customer(c);

        Thread tp1 = new Thread(p1);
        tp1.setName("厂商甲");

        Thread tc1 = new Thread(c1);
        tc1.setName("商店A");
        Thread tc2 = new Thread(c2);
        tc2.setName("商店B");

        tp1.start();
        tc1.start();
        tc2.start();

    }


}



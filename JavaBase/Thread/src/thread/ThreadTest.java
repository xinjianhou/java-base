package thread;

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

class Producer extends Thread {
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

class Customer extends Thread {

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

        // 保证synchronized，wait和notify的对象是一样的才有效，这里使用的是clerk对象，肯定是唯一的。
        Clerk c = new Clerk();
        Producer p1 = new Producer(c);
        Customer c1 = new Customer(c);
        Customer c2 = new Customer(c);


        p1.setName("厂商甲");


        c1.setName("商店A");

        c2.setName("商店B");

        p1.start();
        c1.start();
        c2.start();

    }


}



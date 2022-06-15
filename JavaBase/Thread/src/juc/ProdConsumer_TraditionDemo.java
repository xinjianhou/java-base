package juc;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {

    private Integer num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            //用wile 好于if
            while (num != 0) {
                //waiting
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t success add 1");
            //唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrease() {
        lock.lock();
        try {
            while (num == 0) {
                //waiting
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t success minus 1");
            //唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

/**
 * 一个初始值为0的变量，一个线程给它加1，一个减1， 循环5次
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.increase();
            }

        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.decrease();
            }

        }, "BB").start();
    }


}

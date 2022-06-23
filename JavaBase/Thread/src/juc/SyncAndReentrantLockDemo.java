package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ShareResources {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print(int count, Condition currentC, Condition nextC, int currentV, int nextV) {
        lock.lock();
        try {
            while (number != currentV) {
                currentC.await();
            }
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = nextV;
            nextC.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            c3.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            c1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResources re = new ShareResources();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                re.print(5, re.c1, re.c2, 1, 2);
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                re.print(10, re.c2, re.c3, 2, 3);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                re.print(15, re.c3, re.c1, 3, 1);
            }
        }, "CC").start();
    }

}

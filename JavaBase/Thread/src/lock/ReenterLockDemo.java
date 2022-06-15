package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {

    public synchronized void sendSMS() {

        System.out.println(Thread.currentThread().getName() + " send SMS ");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + " send Email ");
    }

    @Override
    public void run() {
        get();
    }

    private void get() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " do get");
            set();
        } finally {
            lock.unlock();
        }

    }
    private void set() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " do set");
        } finally {
            lock.unlock();
        }

    }
}

/**
 * 可重入锁，指的是外层代码获取了锁，其内层函数或代码也能获得该锁的代码
 * 在同一个线程在外层方法获取锁的同时，在进入内层方法会自动获取锁
 */
public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone p = new Phone();

        new Thread(() -> {
            p.sendSMS();
        }, "t1").start();

        new Thread(() -> {
            p.sendSMS();
        }, "t2").start();


        new Thread(new Phone()).start();

        new Thread(new Phone()).start();

    }
}

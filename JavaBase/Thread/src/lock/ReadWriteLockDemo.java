package lock;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {

    private volatile Map<String, Object> cache = new HashMap<>();
    // Lock lock = new ReentrantLock();

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        //lock.lock();
        lock.writeLock().lock();

        try {

            System.out.println(Thread.currentThread().getName() + " starting to write into cache " + value);
            cache.put(key, value);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " finished to write into cache " + value);
        } finally {
            lock.writeLock().unlock();
            //lock.unlock();
        }
    }

    public Object get(String key) {
        lock.readLock().lock();
        try {
             Object o = null;
             o = cache.get(key);
            System.out.println(Thread.currentThread().getName() + " starting to pull from cache " + key);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " finished to pull from cache " + o);

            return o;
        } finally {
            lock.readLock().unlock();
        }


    }

}

/**
 * 读共享，写独占
 * 写的时候不能读，读的时候不能写.
 *
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache cache = new MyCache();


//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                cache.put(finalI + "",
                        finalI);

            }, "t1").start();
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                cache.get(1 + "");


            }, "t2 ").start();
        }




    }
}

package chapter10;

import java.util.concurrent.TimeUnit;

/**
 * -XX:+PrintCommandLineFlags
 * or
 * JPS
 * jinfo -flag UseG1GC xxx
 *
 *(+/-)UseSerialGC
 * (+/-)UseParNewGC
 * ParNewGCThreads=
 * (+/-)UseConcMarkSweepGC
 * (+/-)UseParallelGC
 * (+/-)UseParallelOldGC
 * ParallelGCThreads=
 */
public class GCKindDemo {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            TimeUnit.SECONDS.sleep(1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

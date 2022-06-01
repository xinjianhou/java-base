package threadpool;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {



        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("线程"+t.getName());
           // t.setPriority(Thread.MAX_PRIORITY);
            System.out.println("create " + t);
            return t;
        }




}


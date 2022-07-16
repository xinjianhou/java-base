package chapter09;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakRef {

    public static WeakRef obj;
    public static ReferenceQueue<WeakRef> queue = null;

    public static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            while(true){
                if(queue != null){
                    WeakReference<WeakRef> objw = null;

                    objw = (WeakReference<WeakRef>) queue.poll();
                   
                    if(objw!=null){
                        System.out.println(objw);
                        System.out.println("追踪垃圾回收过程： WeakRef实例被回收了！！！");
                        System.out.println(queue.poll());
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        queue = new ReferenceQueue<>();
        obj = new WeakRef();

        WeakReference<WeakRef> weakReference = new WeakReference<>(obj,queue);

        try {
            System.out.println(weakReference);
            System.out.println(weakReference.get()) ;

            obj = null;
            System.gc();

            TimeUnit.SECONDS.sleep(1l);
            if(obj == null){
                System.out.println("cleaned!!");
            }else{
                System.out.println("still alive!!");
            }



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

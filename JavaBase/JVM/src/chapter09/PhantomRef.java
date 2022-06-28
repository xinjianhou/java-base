package chapter09;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

public class PhantomRef {

    public static PhantomRef obj;
    public static ReferenceQueue<PhantomRef> queue = null;

    public static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            while(true){
                if(queue != null){
                    PhantomReference<PhantomRef> objp = null;

                    try {
                        objp = (PhantomReference<PhantomRef>) queue.remove();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(objp!=null){
                        System.out.println("追踪垃圾回收过程： PhantomRef实例被回收了！！！");
                    }
                }
            }

        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类finalize（）");
        obj = this;
    }

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        queue = new ReferenceQueue<>();
        obj = new PhantomRef();

        PhantomReference<PhantomRef> phantomReference = new PhantomReference<>(obj,queue);

        try {
            System.out.println(phantomReference.get()) ;

            obj = null;
            System.gc();

            TimeUnit.SECONDS.sleep(1l);
            if(obj == null){
                System.out.println("cleaned!!");
            }else{
                System.out.println("still alive!!");
            }

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

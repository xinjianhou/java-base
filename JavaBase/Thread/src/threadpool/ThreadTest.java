package threadpool;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {
    static Long count = 100000000L;

    static List<String> texts = new ArrayList<String>();
    static String text = "%010dxxl";

    public static void main(String[] args) throws InterruptedException {

//        ExecutorService tpc = Executors.newCachedThreadPool();//快
 //       ExecutorService tpf = Executors.newFixedThreadPool(5);//慢
//        ExecutorService tps = Executors.newSingleThreadExecutor();//最慢，单线

        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 30, 10l,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(20), new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        List<String> subTexts = new ArrayList<>();
        for (int i = 0; i <= count; i++) {


            subTexts.add(String.format(text, i));
            if(subTexts.size() == 5000000){
                texts.addAll(subTexts);
                MyTask task = new MyTask(i+".txt", subTexts);
                tpe.execute(task);
                subTexts = new ArrayList<>();
            }
        }
        System.out.println(texts.size());

        
        tpe.shutdown();




    }


}




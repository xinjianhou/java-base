package singletonwithproperty;

import java.util.concurrent.*;

public class SingletonTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton instance = Singleton.INSTANCE;
        System.out.println(instance);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Singleton> s1 = service.submit(new Task());
        Future<Singleton> s2 = service.submit(new Task());

        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s1.get() == s2.get());
        System.out.println(instance == s2.get());
        service.shutdown();


    }

}

class Task implements Callable<Singleton> {

    @Override
    public Singleton call() throws Exception {
        return Singleton.INSTANCE;
    }
}


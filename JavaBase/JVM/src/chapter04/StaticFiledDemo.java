package chapter04;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StaticFiledDemo {

    /**
     * 静态变量引用的对象本身放在堆空间里
     * -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails
     */
   private static byte[] bites = new byte[1024*1024*100];

    public static void main(String[] args) {
        System.out.println(StaticFiledDemo.bites);


//        try {
//            TimeUnit.SECONDS.sleep(1000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}

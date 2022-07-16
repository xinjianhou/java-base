package chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OOMtest {

    private byte[] heap = new byte[1024*1024];

    public static void main(String[] args) {
        List<OOMtest> list = new ArrayList<>();
        while(true){
            try {
                TimeUnit.SECONDS.sleep(20l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(new OOMtest());
        }
    }
}

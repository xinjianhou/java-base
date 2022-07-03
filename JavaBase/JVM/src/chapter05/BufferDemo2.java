package chapter05;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * -XX:MaxDirectMemorySize=10m
 */
public class BufferDemo2 {

    private static final int BUFFER = 1024 * 1024;

    public static void main(String[] args) {


        List<ByteBuffer> list = new ArrayList<ByteBuffer>();

        int count = 0;
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
            list.add(byteBuffer);
            count++;
            try {
                TimeUnit.SECONDS.sleep(1l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println(count);

            }

        }
    }
}

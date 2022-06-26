package chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OOMtest {

    private byte[] heap = new byte[1024*1024];

    public static void main(String[] args) {
        List<OOMtest> list = new ArrayList<>();
        while(true){
            list.add(new OOMtest());
        }
    }
}

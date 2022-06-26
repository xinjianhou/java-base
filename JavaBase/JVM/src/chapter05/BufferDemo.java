package chapter05;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * 查看直接内存
 */
public class BufferDemo {

    private static final int BUFFER = 1024 * 1024 * 1024;

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配结束，请指示");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("开始释放内存");
        byteBuffer = null;
        System.gc();
        scanner.next();


    }
}

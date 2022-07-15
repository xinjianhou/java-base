package chapter05;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {

    private static final String FILE = "/Users/xinjianhou/Music/iTunes/iTunes Media/Movies/守望者/守望者.mp4";
    private static final int BUFFER = 1024 * 1024 * 100;

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            String des = "/Users/xinjianhou/守望者" + i + ".mp4";
//            sum += io(FILE, des); 28823
            sum += directBuff(FILE, des); //16605

        }
        System.out.println(sum);
    }

    private static long io(String src, String des) {
        long start = System.currentTimeMillis();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(des);
            byte[] buff = new byte[BUFFER];
            while (true) {
                int len = inputStream.read(buff);
                if (len == -1) {
                    break;
                }
                outputStream.write(buff);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return System.currentTimeMillis() - start;


    }

    private static long directBuff(String src, String des) {
        long start = System.currentTimeMillis();
        FileChannel fileIn = null;
        FileChannel fileOut = null;
        try {
            fileIn = new FileInputStream(src).getChannel();
            fileOut = new FileOutputStream(des).getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);

            while (fileIn.read(byteBuffer) != -1) {
                byteBuffer.flip();
                fileOut.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileIn.close();
                fileOut.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return System.currentTimeMillis() - start;
    }
}

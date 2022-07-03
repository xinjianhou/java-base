package chapter05;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -XX:MaxDirectMemorySize=10m
 */
public class MaxDirectMemorySizeDemo {

    private static final long _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);


        while (true) {

            unsafe.allocateMemory(_1MB);
        }
    }

}

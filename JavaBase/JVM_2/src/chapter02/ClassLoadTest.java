package chapter02;

import java.util.Arrays;
import java.util.Scanner;

public class ClassLoadTest {

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader("/Users/xinjianhou/GIT/java-base/JavaBase/out/production/jvm/chapter01");

        try {
            Class clazz = classLoader.loadClass("StackStrucTest");
            System.out.println(clazz.getMethods().getClass().toString());
            System.out.println(Arrays.stream(clazz.getConstructors()).findFirst().toString());
            Scanner scanner = new Scanner(System.in);
            scanner.next();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package chapter01;

import java.util.concurrent.TimeUnit;

public class StackStrucTest {

    public static void main(String[] args) {
        // int i = 2 + 3;

        int i = 2;
        int j = 3;
        int k = i + j;

        try {
            //javap -v StackStrucTest.class

            TimeUnit.SECONDS.sleep(10l);
            //quit JVM
            System.exit(0);
            Runtime.getRuntime().exit(0);
            Runtime.getRuntime().halt(0);
            //jps

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}

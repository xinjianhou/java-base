package chapter02;

import com.sun.istack.internal.Nullable;

public class ClassInitTest {

    private static int i = 1;
    @Nullable
    private static String s;

    static {
        number = 10;
        s = "hello";
        System.out.println(s);
        //System.out.println(number); Illegal forward reference
    }

    static int number = 5;

    public static void main(String[] args) {

        System.out.println(ClassInitTest.number);



    }
}

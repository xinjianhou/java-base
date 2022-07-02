package chapter04;

public class  MethodAreaTest {
    public static void main(String[] args) {
        Order o = null;
        System.out.println(o.count);
        System.out.println(o.num);
        System.out.println(o.l);
        o.sayHello();

    }
}

class Order {
    public static int count = 1;

    public static long l;

    {
        l = 199999l;
    }
    public static final int num = 9;

    public static void sayHello() {
        System.out.println("Hello World!");
    }
}

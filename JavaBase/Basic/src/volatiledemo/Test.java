package volatiledemo;

public class Test {
    int a = 0;

    boolean flag = false;

    public void method1() {
        a = 1; //指令重排的可能
        flag = true;
    }

    public void method2() {
        if (flag) {
            a = a + 5;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        for (int i = 0; i < 200000; i++) {
            new Thread(() -> {

                t.method1();



            }, "test:" + i).start();
            new Thread(() -> {


                t.method2();
                if (t.a == 5)
                    System.out.println(t.a);

            }, "test:" + i).start();
        }

    }
}

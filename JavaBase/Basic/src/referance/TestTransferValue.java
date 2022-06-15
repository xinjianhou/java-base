package referance;

public class TestTransferValue {
    public void changeV1(int age) {
        age = 30;
    }

    public void changeV2(User u) {
        u.setName("hello");
    }

    public void changeV3(String s) {
        s = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue t = new TestTransferValue();
        int age = 20;
        t.changeV1(age);
        System.out.println("age: " + age);//20

        User u = new User("world");
        t.changeV2(u);
        System.out.println("user: " + u.getName()); //hello

        String s = "test";
        t.changeV3(s);
        System.out.println("String:"+s);//test

        String s1 = new String("test");
        t.changeV3(s1);
        System.out.println("String:"+s1);//test
    }
}

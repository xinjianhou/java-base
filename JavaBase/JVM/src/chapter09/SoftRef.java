package chapter09;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * -Xms15m -Xmx15m -XX:+PrintGCDetails
 */
public class SoftRef {

    public static class User{
        byte[] heap = new byte[2 * 1024 * 1024];
        int age;
        String name;
        public User(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        SoftReference<User> softReference = new SoftReference<>(new User(18,"xiaohua"), new ReferenceQueue<User>());
        User user = new User(12, "xiaoming");
        System.gc();
        System.out.println(softReference.get());

        try {
            byte[] b = new byte[1024 * 1024 * 7];
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(softReference.get());
            System.out.println(user);
        }
    }
}

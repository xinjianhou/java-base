package cas;


import java.util.concurrent.atomic.AtomicReference;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;

    }
    public String toString(){
        return "name: " +name + " age: "+ age;
    }
}

public class AtomicReferanceTest {

    public static void main(String[] args) {

        AtomicReference<User> ai = new AtomicReference<>();
        User z3 = new User("zhang san", 18);
        User l4 = new User("li si", 19);

        ai.set(z3);

        System.out.println(ai.compareAndSet(z3,l4)+" now coming to us is:" + ai.get());
        System.out.println(ai.compareAndSet(z3,l4)+" now coming to us is:" + ai.get());


    }
}

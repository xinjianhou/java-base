package chapter01;


class Parent {
    int x = 10;
    public Parent() {
        print();
        x = 20;
    }
    public void print() {
        System.out.println(Parent.class.getName() + ".x=" + x);
    }
}
class Child extends Parent {
    int x = 30;

    public Child() {
        print();
        x = 40;
    }
    public void print() {
        System.out.println(Child.class.getName() + ".x=" + x);
    }
}
public class TestClassLoad {

    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.x);
    }

}

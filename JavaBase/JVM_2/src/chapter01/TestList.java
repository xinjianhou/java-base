package chapter01;

import java.util.ArrayList;
import java.util.List;

public class TestList implements Cloneable {

    List<String> tests = new ArrayList<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        TestList t = new TestList();
        t.tests.add("hello");

        TestList t1 = new TestList();
        t1.tests.add("hello");

        System.out.println(t.equals(t1));

        TestList t2 = (TestList) t.clone();

        System.out.println(t2.equals(t));

    }
}

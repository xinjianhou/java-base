package chapter05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassInstanceDemo {
    private String s;

    public ClassInstanceDemo(String s) {
        this.s = s;
        System.out.println(s);
    }

    public static void main(String[] args) {
        String s = new String();
        String t;

        {
            try {
                t = String.class.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        Constructor<ClassInstanceDemo> constructor = null;
        try {
            constructor = ClassInstanceDemo.class.getConstructor(String.class);

            Object o = constructor.newInstance("hello");
            System.out.println(o);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


}

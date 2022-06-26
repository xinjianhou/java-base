package chapter05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassInstanceDemo {
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
      Constructor<Object> constructor = (Constructor<Object>) Object.class.getConstructors()[0];
        try {
           Object o =  constructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


}

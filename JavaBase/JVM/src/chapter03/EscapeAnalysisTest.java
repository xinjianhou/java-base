package chapter03;

import java.util.concurrent.TimeUnit;

public class EscapeAnalysisTest {


    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
//            try {
//                TimeUnit.SECONDS.sleep(1l);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            create();

        }
    }

    private static void create() {
      //  Person p = new Person(1,"aa");
        Person p = new Person();
    }

    static class Person {

//       public Person( int age, String name){
//           this.age = age;
//           this.name = name;
//       }
//        int age;
//        String name;

    }
}

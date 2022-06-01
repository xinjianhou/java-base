package singletonwithproperty;

import java.io.IOException;
import java.util.Properties;

public class Singleton {
    private String info;

    private Singleton(String info) {
        this.info = info;
    }
//
//    public String toString(){
//        return String.format("Singleton[%s]", info);
//    }
    public final static Singleton INSTANCE;


    static {
        Properties pro = new Properties();
        try {
            pro.load(Singleton.class.getClassLoader().getResourceAsStream("test.properties"));
            INSTANCE = new Singleton(pro.getProperty("info"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

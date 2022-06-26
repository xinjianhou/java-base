package chapter02;

import java.util.concurrent.TimeUnit;

//-XX:+UseTLAB
public class LoadTest {

    public static void main(String[] args) {
        ClassInitTest test
                = new ClassInitTest();

        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //jvisualvm

        //jps
        //jinfo -flag NewRatio xxx
        //jinfo -flag SurvivorRatio xxx
        //jstat -gc xxx


    }
}

package chapter08;

/**
 * -XX:+PrintGCDetails
 */
public class RefCountGC {

    private byte[] bigSize = new byte[5 * 102481024];

    Object ref = null;

    public static void main(String[] args) {
        RefCountGC rc1 = new RefCountGC();
        RefCountGC rc2 = new RefCountGC();

        rc1.ref = rc2;
        rc2.ref = rc1;

        rc1 = null;
        rc2 = null;

        System.gc();

    }
}

package chapter03;

public class OperAndStackTest {

    public void test() {
        byte i = 127;
        short j = 1 << 14;
        int k = i + j;

    }

    public int sum() {
        byte i = 127;
        short j = 19;
        int k = i + j;
        return k;
    }

    public void testSum() {
        int i = sum();
        int j = 21;
    }
    //javap -verbose .\OperandStackTest.class
}

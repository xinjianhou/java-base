package chapter06;

public class JITConfigTest {

    /**
     *  java -Xint -version 9036
     *  java -Xcomp -version 9486
     *  java -Xmixed -version 10315
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getPrimeNumber(100000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static void getPrimeNumber(int count) {
        for (int i = 0; i < count; i++) {

            outer:for (int j = 2; j < 100; j++) {
                for (int k = 2; k <= Math.sqrt(j); k++) {
                    if (j % k == 0) {
                        continue outer;
                    }
                }
                System.out.println(j);

            }

        }
    }
}

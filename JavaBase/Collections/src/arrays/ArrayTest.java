package arrays;


import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        double[] arr = {1.1, 1.2, 1.4, 12.2};
        arr = (double[]) goodCopyOf(arr, 10);
        System.out.println(Arrays.toString(arr));

        String[] arr1 = {"aa", "bb", "cc"};
        arr1 = (String[]) goodCopyOf(arr1, 10);
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = {"aa", "bb", "cc"};
        arr2 = Arrays.copyOf(arr1, 10);
        System.out.println(Arrays.toString(arr2));

        System.out.println("ClassCastException");
        arr1 = (String[]) badCopyOf(arr1, 20);
    }

    private static Object[] badCopyOf(Object[] arr, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(arr, 0, newArray, 0, Math.min(arr.length, newLength));
        return newArray;
    }

    private static Object goodCopyOf(Object arr, int newLength) {
        Class cls = arr.getClass();
        if (!cls.isArray()) {
            return null;
        }
        Object newArray = Array.newInstance(cls.getComponentType(), newLength);
        System.arraycopy(arr, 0, newArray, 0, Math.min(Array.getLength(arr), newLength));
        return newArray;
    }

}

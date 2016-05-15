package algo;

/**
 * Created by onotole on 15.05.16.
 */
public class FindMax {
    public static int findMax(int[] array) {
        if ( array.length == 0 ) { throw new IllegalArgumentException(); }
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }
        return maxValue;
    }
}

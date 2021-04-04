package arrays;

import java.util.Arrays;

public class RemElements {
    public static int[] collectNewArray(int[][] data, int sum) {
        int[] rsl = new int[data.length * data.length];
        int rslIndex = 0;
        for (int out = 0; out < data.length; out++) {
            for (int in = 0; in < data[out].length; in++) {
                if (out + in == sum) {
                    data[out][in] = 0;
                    continue;
                }
                rsl[rslIndex++] = data[out][in];
            }
        }
        rsl = Arrays.copyOf(rsl, rslIndex);
        return rsl;
    }
}
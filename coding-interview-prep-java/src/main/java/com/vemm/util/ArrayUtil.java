package com.vemm.util;

import java.util.Arrays;

public class ArrayUtil {
    private ArrayUtil() {
    }

    public static int[] concatenateArrays(int[] array1, int[] array2) {
        int[] concatenation = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, concatenation, array1.length, array2.length);
        return concatenation;
    }

    public static int[] removeDuplicate(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }
}

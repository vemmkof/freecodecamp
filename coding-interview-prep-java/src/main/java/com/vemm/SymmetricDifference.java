package com.vemm;

import com.vemm.util.ArrayUtil;

import java.util.Arrays;

public class SymmetricDifference {

    public int[] sym(int[]... sets) {
        int[] set = sets[0];
        for (int i = 1; i < sets.length; i++) {
            set = getSymmetricDiff(set, sets[i]);
        }
        Arrays.sort(set);
        return set;
    }

    private int[] getSymmetricDiff(int[] setA, int[] setB) {
        int[] abDiff = getArray(setA, setB);
        int[] baDiff = getArray(setB, setA);
        return ArrayUtil.removeDuplicate(ArrayUtil.concatenateArrays(abDiff, baDiff));
    }

    private int[] getArray(int[] set1, int[] set2) {
        return Arrays.stream(set1)
                .filter(value -> !contains(set2, value))
                .toArray();
    }

    private boolean contains(int[] set1, int value) {
        for (int i : set1) {
            if (i == value) return true;
        }
        return false;
    }

}

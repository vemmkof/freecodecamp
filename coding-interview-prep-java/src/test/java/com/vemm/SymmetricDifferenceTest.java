package com.vemm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SymmetricDifferenceTest {
    private static SymmetricDifference symmetricDifference;

    @BeforeAll
    public static void setUp() {
        symmetricDifference = new SymmetricDifference();
    }

    @ParameterizedTest(name = "symmetric diff between {0} and {1}, expecting {2}")
    @MethodSource("provideTwoSetsTestData")
    void testWithTwoSets(int[] a, int[] b, int[] result) {
        int[] sym = symmetricDifference.sym(a, b);
        Assertions.assertArrayEquals(sym, result);
    }

    @ParameterizedTest(name = "symmetric diff between {0}, {1} and {2}, expecting {3}")
    @MethodSource("provideThreeSetsTestData")
    void testWithThreeSets(int[] a, int[] b, int[] c, int[] result) {
        int[] sym = symmetricDifference.sym(a, b, c);
        Assertions.assertArrayEquals(sym, result);
    }

    @ParameterizedTest(name = "symmetric diff between {0}, {1}. {2} and {3}, expecting {4}")
    @MethodSource("provideFourSetsTestData")
    void testWithThreeSets(int[] a, int[] b, int[] c, int[] d, int[] result) {
        int[] sym = symmetricDifference.sym(a, b, c, d);
        Assertions.assertArrayEquals(sym, result);
    }

    static Stream<Arguments> provideTwoSetsTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4, 5}, new int[]{3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{1, 2, 4, 5}, new int[]{3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{5, 1, 2, 4, 5}, new int[]{3, 4, 5})
        );
    }

    static Stream<Arguments> provideThreeSetsTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5}, new int[]{3, 2, 5}, new int[]{3, 4, 5}, new int[]{1, 4, 5}),
                Arguments.of(new int[]{1, 2, 5, 1}, new int[]{3, 2, 5}, new int[]{3, 4, 5}, new int[]{1, 4, 5}),
                Arguments.of(new int[]{1, 2, 5}, new int[]{3, 2, 5}, new int[]{5, 3, 4, 5}, new int[]{1, 4, 5})
        );
    }

    static Stream<Arguments> provideFourSetsTestData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5}, new int[]{2, 1, 5, 7}, new int[]{3, 4, 6}, new int[]{1, 2, 3}, new int[]{2, 3, 4, 6, 7}),
                Arguments.of(new int[]{3, 3, 2, 5}, new int[]{2, 1, 5, 7}, new int[]{3, 4, 6}, new int[]{1, 2, 3}, new int[]{2, 3, 4, 6, 7}),
                Arguments.of(new int[]{3, 2, 5}, new int[]{2, 2, 1, 5, 7}, new int[]{3, 4, 6}, new int[]{1, 2, 3}, new int[]{2, 3, 4, 6, 7}),
                Arguments.of(new int[]{3, 2, 5}, new int[]{2, 1, 5, 7}, new int[]{6, 3, 4, 6}, new int[]{1, 2, 3}, new int[]{2, 3, 4, 6, 7}),
                Arguments.of(new int[]{3, 2, 5}, new int[]{2, 1, 5, 7}, new int[]{3, 4, 6}, new int[]{1, 2, 3, 1}, new int[]{2, 3, 4, 6, 7})
        );
    }


}
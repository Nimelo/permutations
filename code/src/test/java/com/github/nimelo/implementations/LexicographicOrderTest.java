package com.github.nimelo.implementations;

import com.github.nimelo.interfaces.LastPermutationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LexicographicOrderTest {
    @Test
    void SimpleTest() throws LastPermutationException {
        Integer[] permutation = new Integer[]{1, 2, 3, 4};
        Integer[] expectedPermutation = new Integer[]{1, 2, 4, 3};

        LexicographicOrder<Integer> generator = new LexicographicOrder<>(permutation);
        Integer[] actualPermutation = generator.next();

        assertArrayEquals(expectedPermutation, actualPermutation);
    }

    @Test
    void FullTestSuite_123() throws LastPermutationException {
        Integer[] permutation = new Integer[]{ 1, 2, 3 };

        LexicographicOrder<Integer> generator = new LexicographicOrder<>(permutation);
        new FullGenerationTestSuite<>(generator, 3 * 2).run();
    }

    @Test
    void FullTestSuite_1234() throws LastPermutationException {
        Integer[] permutation = new Integer[]{ 1, 2, 3, 4 };

        LexicographicOrder<Integer> generator = new LexicographicOrder<>(permutation);
        new FullGenerationTestSuite<>(generator, 4 * 3 * 2).run();
    }
}
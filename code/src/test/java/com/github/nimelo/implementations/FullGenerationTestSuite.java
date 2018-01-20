package com.github.nimelo.implementations;

import com.github.nimelo.interfaces.PermutationGenerator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullGenerationTestSuite<T> implements Runnable {
    private final PermutationGenerator<T> generator;
    private final int threshold;

    public FullGenerationTestSuite(PermutationGenerator<T> generator, int threshold) {
        this.generator = generator;
        this.threshold = threshold;
    }

    @Override
    public void run() {
        List<T[]> permutations = generator.all();

        assertEquals(threshold, permutations.size());
        assertSameSize(permutations);
        assertUnique(permutations);
    }

    private void assertUnique(List<T[]> permutations) {
        for (T[] permutation : permutations) {
            int sameCounter = 0;
            for (T[] permutationToCompare : permutations) {
                if (permutation.equals(permutationToCompare))
                    continue;
                sameCounter = Arrays.equals(permutation, permutationToCompare) ? sameCounter + 1 : sameCounter;
            }
            assertEquals(0, sameCounter);
        }
    }

    private void assertSameSize(List<T[]> permutations) {
        for (T[] permutation : permutations) {
            assertEquals(permutations.get(0).length, permutation.length);
        }
    }
}

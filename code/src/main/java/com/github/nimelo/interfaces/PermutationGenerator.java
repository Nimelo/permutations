package com.github.nimelo.interfaces;

import java.util.Arrays;
import java.util.List;

public abstract class PermutationGenerator<T> {
    protected T[] currentPermutation;

    public PermutationGenerator(T[] permutation) {
        this.currentPermutation = Arrays.copyOf(permutation, permutation.length);
    }

    public abstract T[] next() throws LastPermutationException;

    public abstract List<T[]> all();

    protected void swap(int lhsIndex, int rhsIndex) {
        T tmp = currentPermutation[lhsIndex];
        currentPermutation[lhsIndex] = currentPermutation[rhsIndex];
        currentPermutation[rhsIndex] = tmp;
    }
}

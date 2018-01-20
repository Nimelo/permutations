package com.github.nimelo.implementations;

import com.github.nimelo.interfaces.LastPermutationException;
import com.github.nimelo.interfaces.PermutationGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicOrder<T extends Comparable> extends PermutationGenerator<T> {

    public LexicographicOrder(T[] permutation) {
        super(permutation);
    }

    public T[] next() throws LastPermutationException {
        int k = findNonIncreasingSuffix();

        if (k < 0)
            throw new LastPermutationException();

        int l = findSuccessorToPivot(k);

        swap(l, k);

        reverseBetween(k + 1, currentPermutation.length - 1);

        return Arrays.copyOf(currentPermutation, currentPermutation.length);
    }

    @Override
    public List<T[]> all() {
        Arrays.sort(this.currentPermutation);
        List<T[]> permutations = new ArrayList<>();
        permutations.add(Arrays.copyOf(currentPermutation, currentPermutation.length));

        while (true) {
            try {
                permutations.add(next());
            } catch (LastPermutationException e) {
                break;
            }
        }

        return permutations;
    }

    private void reverseBetween(int lhsIndex, int rhsIndex) {
        while (lhsIndex < rhsIndex) {
            swap(lhsIndex, rhsIndex);
            ++lhsIndex;
            --rhsIndex;
        }
    }

    private int findSuccessorToPivot(int pivot) {
        int l = currentPermutation.length - 1;
        while(l > pivot && !(currentPermutation[l].compareTo(currentPermutation[pivot]) > 0))
            --l;
        return l;
    }

    private int findNonIncreasingSuffix() {
        int i = currentPermutation.length - 2;
        while (i >= 0 && !(currentPermutation[i].compareTo(currentPermutation[i + 1]) < 0))
            --i;
        return i;
    }
}

package org.example.sortingalgorithms;

import java.util.List;

public class SelectionSort implements SortingService {

    @Override
    public List<Integer> sort(List<Integer> unsortedArray) {
        int n = unsortedArray.size();

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (unsortedArray.get(j) < unsortedArray.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {

                int temp = unsortedArray.get(i);
                unsortedArray.set(i, unsortedArray.get(minIndex));
                unsortedArray.set(minIndex, temp);

            }
        }
        return unsortedArray;
    }
}

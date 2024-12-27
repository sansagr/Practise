package org.example.sortingalgorithms;

import java.util.List;
import java.util.Collections;

public class BubbleSort implements SortingService {

    @Override
    public List<Integer> sort(List<Integer> unsortedArray) {
        int n = unsortedArray.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (unsortedArray.get(j) > unsortedArray.get(j + 1)) {
                    int temp = unsortedArray.get(j + 1);
                    unsortedArray.set(j + 1, unsortedArray.get(j));
                    unsortedArray.set(j, temp);
                }
            }
        }
        return unsortedArray;
    }
}

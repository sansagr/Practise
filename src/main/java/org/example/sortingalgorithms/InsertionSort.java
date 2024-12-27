package org.example.sortingalgorithms;

import java.util.List;

public class InsertionSort implements SortingService{

    @Override
    public List<Integer> sort(List<Integer> unsortedArray){
        int n = unsortedArray.size();

        for(int i = 1; i < n; i ++){
            int element = unsortedArray.get(i);
            int j = i-1;
            while (j > -1 && unsortedArray.get(j) > element){
                int temp = unsortedArray.get(j);
                unsortedArray.set(j, unsortedArray.get(j+1));
                unsortedArray.set(j+1, temp);
                j--;
            }
        }
        return unsortedArray;
    }
}

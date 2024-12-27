package org.example.sortingalgorithms;

import java.util.List;

public class QuickSort implements SortingService {

    @Override
    public List<Integer> sort(List<Integer> unsortedArray) {
        int n = unsortedArray.size();
        quickSort(unsortedArray, 0, n-1);
        return unsortedArray;
    }

    public void quickSort(List<Integer> array, int low, int high){
        if (low < high){
            int pivotIndex = partition(array, low, high);
            System.out.println(pivotIndex + " " + array + " " + low + " " + high);
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex+1, high);
        }
    }

    static void swap(List<Integer> array, int i, int j){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public Integer partition(List<Integer> array, int low, int high){
        int pivot = array.get(high);
        int i = low-1;
        for (int j = low; j < high;j++){
        System.out.println(pivot + " "+ low + " " + high + " "+ array);
            if (array.get(j) < pivot){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        System.out.println(pivot + " "+ i+1 + " " + low + " " + high + " "+ array);
        return i+1;
    }
}

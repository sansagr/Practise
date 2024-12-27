package org.example.sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> unsortedArray = new ArrayList<Integer>(Arrays.asList(-2, 1, 2, 41, 7, 43, 0, 26, -1));
        System.out.println(unsortedArray);
        List<Integer> sortedArray = quickSort.sort(unsortedArray);
        System.out.println(sortedArray);


    }
}

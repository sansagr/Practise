package org.example;

import java.util.Arrays;
import java.util.List;

public class MyTask {

    public void myMethod(String input) {
        System.out.println("Processing " + input + " in thread: " + Thread.currentThread().getName());
        // method logic here
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        List<String> items = Arrays.asList("A", "B", "C", "D", "E");

        // Process each item in parallel
        items.parallelStream().forEach(task::myMethod);
    }
}

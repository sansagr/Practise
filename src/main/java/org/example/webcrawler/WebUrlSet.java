package org.example.webcrawler;

import java.util.HashSet;
import java.util.Set;

public class WebUrlSet {
    private static WebUrlSet instance;
    private Set<String> webUrlSet;

    private WebUrlSet() {
        this.webUrlSet = new HashSet<>();
    }

    public static synchronized WebUrlSet getInstance() {
        if (instance == null) {
            instance = new WebUrlSet();
        }
        return instance;
    }

    public synchronized void add(String s) {
        webUrlSet.add(s);
    }

    public synchronized boolean contains(String s) {
        return webUrlSet.contains(s);
    }

    public synchronized int size() {
        return webUrlSet.size();
    }

    public synchronized void clear(){
        webUrlSet.clear();
    }
}

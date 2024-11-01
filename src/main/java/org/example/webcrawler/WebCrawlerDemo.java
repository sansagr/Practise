package org.example.webcrawler;

import java.lang.reflect.Array;
import java.util.*;

public class WebCrawlerDemo {
    public static void main(String[] args){

        List<String> startingUrls = new ArrayList<>(Arrays.asList("www.wikipedia.com","www.worldmaps.com","www.encyclopedia.com"));

        WebsiteCrawler crawler = new WebsiteCrawler();
        crawler.webCrawler(startingUrls);

    }
}

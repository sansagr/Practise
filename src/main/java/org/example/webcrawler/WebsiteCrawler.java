package org.example.webcrawler;

import java.util.*;

public class WebsiteCrawler implements Crawler {

    public void webCrawler(List<String> urls){
//      set to keep track of visited webpages based on url
        Set<String> webpageSet= new HashSet<>();
        Queue<String> webLinkQueue = new ArrayDeque<>(urls);


        while (!webLinkQueue.isEmpty()){
            String nodeUrl = webLinkQueue.poll();
            webpageSet.add(nodeUrl);

//          fetches raw content of webpage
            WebPageFetcher fetcher = new WebPageFetcher();
            PageHTML rawWebPage =  fetcher.fetchWebPage(nodeUrl);

//          processes the raw content to get the links and content
            WebProcessor processor = new WebProcessor();
            Webpage webpage = processor.webPageProcessor(rawWebPage);

//          get links that were available on the page
            List<String> links = webpage.getLinks();

            for (String link: links){
//              skip the pages that are already crawled
                if (!webpageSet.contains(link)){
                    webLinkQueue.add(link);
                }
            }
        }

    }
}

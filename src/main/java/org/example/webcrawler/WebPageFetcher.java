package org.example.webcrawler;

public class WebPageFetcher implements Fetcher{

    @Override
    public PageHTML fetchWebPage(String url) {
//        does some network calls
//        fetches the raw content of a page using url
        return new PageHTML();
    }
}

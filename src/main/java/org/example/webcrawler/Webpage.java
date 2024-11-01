package org.example.webcrawler;

import java.util.List;


public class Webpage {
    public final List<String> links;
    public final String content;
    public final String url;

    public Webpage(List<String> links, String content, String url) {

        this.links = links;
        this.content = content;
        this.url = url;
    }

}

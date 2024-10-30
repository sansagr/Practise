package org.example.webcrawler;

import java.util.List;
public class Webpage {
    private  List<String> links;
    private String content;
    private String url;

    public Webpage(List<String> links, String content, String url){
        this.links = links;
        this.content = content;
        this.url = url;
    }

    public List<String> getLinks(){
        return links;
    }

    public String getContent(){
        return content;
    }

    public String getURL(){
        return url;
    }

}

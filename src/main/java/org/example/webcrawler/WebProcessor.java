package org.example.webcrawler;

import java.util.ArrayList;
import java.util.List;

public class WebProcessor implements Processor {

    @Override
    public Webpage webPageProcessor(PageHTML rawWebPage){

//        does some processing
        List<String> links = new ArrayList<String>();
        String url = "url";
        String content = "content";

        return new Webpage(links, content, url);
    }
}

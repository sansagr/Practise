package org.example.webcrawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebPageProcessor {

    public Webpage processWebPage(Document rawWebPage, String url) {

        List<String> embeddedLinks = new ArrayList<>();
        Elements links = rawWebPage.select("a[href]");
        for (Element link : links) {
            String href = link.attr("href");
            if (href.startsWith("http://") || href.startsWith("https://")) {
                embeddedLinks.add(href);
            }
        }

        String content = "content";

        return new Webpage(embeddedLinks, content, url);
    }
}

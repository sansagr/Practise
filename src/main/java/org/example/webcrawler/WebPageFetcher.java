package org.example.webcrawler;

import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.Connection;

import java.io.IOException;

@Log4j2
public class WebPageFetcher {

    public Document fetchWebPage(String url) throws IOException {
//        does some network calls
//        fetches the raw content of a page using url
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0 Safari/537.36")
                    .timeout(5000)
                    .execute();
            if (response.statusCode() == 200) {
                return response.parse();
            }
        } catch (Exception e) {
            log.error("Exception occured while fetching the page: {}", e.getMessage());
        }

        return new Document("url");

    }
}

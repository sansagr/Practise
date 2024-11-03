package org.example.webcrawler;

import com.mongodb.client.MongoDatabase;
import lombok.extern.log4j.Log4j2;
import org.example.webcrawler.repositories.WebpageStore;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.*;

@Log4j2
public class WebsiteCrawler {

    private final List<String>  listOfUrls = new ArrayList<>(List.of("https://www.wikipedia.com/", "https://medium.com", "https://www.reddit.com/"));
    private final WebpageStore webpageStore;
    private boolean isPaused;
    private final WebUrlSet webUrlSet;

    public WebsiteCrawler(MongoDatabase database) {
        this.webUrlSet = WebUrlSet.getInstance();
        this.webpageStore = new WebpageStore(database);
        this.isPaused = false;

    }

    public void startOrResumeCrawl() {
        listOfUrls.parallelStream().forEach(this::crawlUrl);
    }


    private void crawlUrl(String url) {
        isPaused = false;
        List<Webpage> webpages = new ArrayList<>();
        Queue<String> webLinkQueue = new ArrayDeque<>(Collections.singletonList(url));
        try {
            while (!webLinkQueue.isEmpty() && !isPaused) {
                String nodeUrl = webLinkQueue.poll();
                webUrlSet.add(nodeUrl);

//              fetches raw content of webpage
                WebPageFetcher fetcher = new WebPageFetcher();
                Document rawWebPage = fetcher.fetchWebPage(nodeUrl);

//              processes the raw content to get the links and content
                WebPageProcessor processor = new WebPageProcessor();
                Webpage webpage = processor.processWebPage(rawWebPage, nodeUrl);

//              get links that were available on the page
                List<String> links = webpage.links;

                webpages.add(webpage);
//              Storing data in DB in batches of 10 and cleaning up the local variables
                if (webpages.size() >= 10) {
//                  TODO: add exception handling for store
                    webpageStore.insertManyWebpages(webpages);
                    webpages.clear();
                }

                for (String link : links) {
//                  skip the pages that are already crawled
                    if (!webUrlSet.contains(link)) {
                        log.info("Adding the link " + link + " to the queue" + " in " + Thread.currentThread().getName());
                        webLinkQueue.add(link);
                        webUrlSet.add(link);
                    }
                }
                log.info("the number of pages in hashset: {}", webUrlSet.size());
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception (log it, rethrow, etc.)
        }
    }

    public void pauseCrawl() {
        isPaused = true;
    }

    public void clearCrawlState() {
//      resets all the relevant variables so that the state is new
        webUrlSet.clear();
        isPaused = false;
    }

}

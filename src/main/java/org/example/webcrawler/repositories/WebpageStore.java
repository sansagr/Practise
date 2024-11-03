package org.example.webcrawler.repositories;

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.extern.log4j.Log4j2;
import org.example.webcrawler.Webpage;

import java.util.List;

@Log4j2
public class WebpageStore {
    private final MongoCollection<Webpage> webpageMongoCollection;

    public WebpageStore(MongoDatabase database) {
        this.webpageMongoCollection = database.getCollection("webpages", Webpage.class);
    }

    public void insertOneWebpage(Webpage webpage) {
        webpageMongoCollection.insertOne(webpage);
        log.info("Insertion of webpage with URL: {} successfull", webpage.url);
    }

    public void insertManyWebpages(List<Webpage> webpageList) {
        webpageMongoCollection.insertMany(webpageList);
        log.info("Insertion of {} webpages successful", webpageList.size());
    }

    public Webpage getWebpageByUrl(String url) {
        return webpageMongoCollection.find(Filters.eq("url", url)).first();
    }
}

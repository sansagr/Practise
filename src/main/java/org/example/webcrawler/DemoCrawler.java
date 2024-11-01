package org.example.webcrawler;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.example.config.Appconfig;
import org.example.config.MongoConfig;

import java.io.IOException;
import java.util.*;

public class DemoCrawler {
    @SneakyThrows
    public static void main(String[] args) throws IOException {


//      connect to mongodb when application spins up
        MongoClient mongoClient = MongoConfig.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("downToFlat");

//      Starts the crawl
        WebsiteCrawler crawler = new WebsiteCrawler(database);
        crawler.startOrResumeCrawl();


    }
}

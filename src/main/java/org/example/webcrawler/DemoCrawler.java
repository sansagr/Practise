package org.example.webcrawler;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.example.config.Appconfig;
import org.example.config.MongoClientManager;

import java.io.IOException;

public class DemoCrawler {
    public static void main(String[] args) throws IOException {

//      Get startup configs
        Appconfig config = Appconfig.getInstance();

//      connect to mongodb when application spins up
        MongoClient mongoClient = MongoClientManager.getInstance();
        MongoDatabase database = mongoClient.getDatabase("downToFlat");

//      Starts the crawl
        WebsiteCrawler crawler = new WebsiteCrawler(database);
        crawler.startOrResumeCrawl();


    }
}

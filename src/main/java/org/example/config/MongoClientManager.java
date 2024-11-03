package org.example.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.ConnectionString;

import lombok.extern.log4j.Log4j2;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


@Log4j2
public class MongoClientManager {
    private static MongoClient mongoClient;

    public static MongoClient getInstance() {
        if (mongoClient == null){
            synchronized (MongoClientManager.class){
                if(mongoClient == null){
                    mongoClient = createMongoClient();
                }

            }
        }
        return mongoClient;
    }

    private static MongoClient createMongoClient() {
        Appconfig config = Appconfig.getInstance();
        String mongoConnectionString = config.getConfigValue("database.url");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(getDefaultCodecRegistry(), pojoCodecRegistry);

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoConnectionString))
                .serverApi(serverApi)
                .codecRegistry(codecRegistry)
                .build();

        return MongoClients.create(settings);
    }

    public static void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }


}

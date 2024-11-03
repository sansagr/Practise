package org.example.config;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

@Log4j2
public class Appconfig {

    private static Appconfig instance;
    private final Properties properties = new Properties();

    private Appconfig(){
        try(InputStream input = Appconfig.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input == null){
                log.warn("Unable to find application.properties");
            }else{
                properties.load(input);
                log.info("Loaded application.properties successfully");
            }


        }
        catch (IOException e){
            log.error("Error loading application.properties: {}", e.getMessage());
        }
    }

    public static Appconfig getInstance(){
        if (instance == null){
            synchronized (Appconfig.class){
                if (instance == null){
                    instance = new Appconfig();
                }
            }
        }
        return instance;
    }

    public String getConfigValue(String configName){
       return properties.getProperty(configName);
    }
}

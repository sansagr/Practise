package org.example.config;

import lombok.extern.log4j.Log4j2;

import java.util.Properties;
import java.io.InputStream;

@Log4j2
public class Appconfig {

    public String getConfigValue(String configName){
        Properties prop = new Properties();
        try(InputStream input = Appconfig.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input == null){
                log.warn("Sorry, Unable to find application.properties");
                return null;
            }
            prop.load(input);
        }
        catch (Exception e){
            log.error("Got an error in fetcing configs: {}", e.getMessage());
        }
        return prop.getProperty(configName);
    }
}

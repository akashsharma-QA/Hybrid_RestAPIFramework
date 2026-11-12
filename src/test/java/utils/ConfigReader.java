package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties properties;
    private static final String config_file_prop="src/test/resources/config.properties";

    public ConfigReader(){

        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(config_file_prop);
            properties.load(fis);

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }


    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
    public int getIntProperty(String key){
        return Integer.parseInt(properties.getProperty(key));
    }

}

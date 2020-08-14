package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String CONFIG = "config.properties";
    private static final String API_KEY = "ORS_TOKEN";
    private static Config INSTANCE = new Config();

    private Properties properties;

    private Config() {
        properties = new Properties();
        load();
    }

    private void load() {
        try(InputStream inputStream = new FileInputStream(
                getClass().getClassLoader().getResource(CONFIG).getFile())) {
            properties.load(inputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public String getAPIKey() {
        return properties.getProperty(API_KEY);
    }
}

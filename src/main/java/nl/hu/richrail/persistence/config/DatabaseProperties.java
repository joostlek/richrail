package nl.hu.richrail.persistence.config;

import nl.hu.richrail.exceptions.NoPropertiesSetException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProperties implements DatabaseConfig {
    private Logger logger = Logger.getLogger(DatabaseProperties.class.getName());

    @Override
    public Config getDatabaseConfig() {
        try {
            String path = DatabaseProperties.class.getResource("/").getPath() + "app.properties";
            Properties appProps = new Properties();
            FileInputStream fileInputStream = new FileInputStream(path);
            appProps.load(fileInputStream);
            if (appProps.get("DB.HOST").equals("")) {
                throw new NoPropertiesSetException();
            }
            Config config = new Config(appProps.getProperty("DB.HOST"),
                    appProps.getProperty("DB.USER"),
                    appProps.getProperty("DB.PASS"));
            fileInputStream.close();
            return config;
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new NoPropertiesSetException();
        }
    }
}

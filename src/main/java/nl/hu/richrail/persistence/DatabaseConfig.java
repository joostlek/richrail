package nl.hu.richrail.persistence;

import nl.hu.richrail.exceptions.NoPropertiesSetException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {

    String host;

    String username;

    String password;

    public DatabaseConfig() throws IOException {
        String path = DatabaseConfig.class.getResource("/").getPath() + "app.properties";
        Properties appProps = new Properties();
        FileInputStream fileInputStream = new FileInputStream(path);
        appProps.load(fileInputStream);
        if (appProps.get("DB.HOST").equals("")) {
            throw new NoPropertiesSetException();
        }
        this.host = appProps.getProperty("DB.HOST");
        this.username = appProps.getProperty("DB.USER");
        this.password = appProps.getProperty("DB.PASS");
        fileInputStream.close();
    }
}

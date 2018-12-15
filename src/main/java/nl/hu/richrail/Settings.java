package nl.hu.richrail;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Settings {

    private final boolean memoryEnabled;

    private final boolean fileEnabled;

    private final String filePath;

    private final boolean databaseEnabled;

    private final String databaseUrl;

    private final String databaseUsername;

    private final String databasePassword;

    Settings(Config config) {
        config.checkValid(ConfigFactory.defaultReference(), "richrail");

        memoryEnabled = config.getBoolean("richrail.storage.memory.enabled");
        fileEnabled = config.getBoolean("richrail.storage.file.enabled");
        filePath = config.getString("richrail.storage.file.path");
        databaseEnabled = config.getBoolean("richrail.storage.database.enabled");
        databaseUrl = config.getString("richrail.storage.database.url");
        databaseUsername = config.getString("richrail.storage.database.username");
        databasePassword = config.getString("richrail.storage.database.password");
    }

    public boolean isMemoryEnabled() {
        return memoryEnabled;
    }

    public boolean isFileEnabled() {
        return fileEnabled;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isDatabaseEnabled() {
        return databaseEnabled;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

}

package nl.hu.richrail.persistence;

import nl.hu.richrail.Settings;
import nl.hu.richrail.exceptions.InvalidStorageMethodException;
import nl.hu.richrail.persistence.database.DatabaseConfig;
import nl.hu.richrail.persistence.database.DatabaseStorage;
import nl.hu.richrail.persistence.file.FileConfig;
import nl.hu.richrail.persistence.file.FileStorage;
import nl.hu.richrail.persistence.memory.MemoryStorage;

public class StorageMethodFactory {

    private final Settings settings;

    public StorageMethodFactory(Settings settings) {
        this.settings = settings;
    }

    public StorageMethod create() {
        if (this.settings.isMemoryEnabled()) {
            return new MemoryStorage();
        } else if (this.settings.isFileEnabled()) {
            return new FileStorage(new FileConfig(this.settings.getFilePath()));
        } else if (this.settings.isDatabaseEnabled()) {
            return new DatabaseStorage(new DatabaseConfig(
                    this.settings.getDatabaseUrl(),
                    this.settings.getDatabaseUsername(),
                    this.settings.getDatabasePassword()));
        } else {
            throw new InvalidStorageMethodException();
        }
    }

}

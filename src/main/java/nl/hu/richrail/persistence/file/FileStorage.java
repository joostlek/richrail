package nl.hu.richrail.persistence.file;

import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;

public class FileStorage implements StorageMethod {

    private final FileConfig config;

    public FileStorage(FileConfig config) {
        this.config = config;
    }

    @Override
    public TrainRepository getTrainRepository() {
        return null;
    }

    @Override
    public ComponentRepository getComponentRepository() {
        return null;
    }

}

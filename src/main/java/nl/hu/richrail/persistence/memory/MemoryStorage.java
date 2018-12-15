package nl.hu.richrail.persistence.memory;

import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;

public class MemoryStorage implements StorageMethod {

    public MemoryStorage() {

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

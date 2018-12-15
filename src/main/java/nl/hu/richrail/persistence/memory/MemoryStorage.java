package nl.hu.richrail.persistence.memory;

import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.memory.repositories.MemoryComponentRepository;
import nl.hu.richrail.persistence.memory.repositories.MemoryTrainRepository;

public class MemoryStorage implements StorageMethod {

    private final TrainRepository trainRepository;

    private final ComponentRepository componentRepository;

    public MemoryStorage() {
        this.trainRepository = new MemoryTrainRepository();
        this.componentRepository = new MemoryComponentRepository();
    }

    @Override
    public TrainRepository getTrainRepository() {
        return this.trainRepository;
    }

    @Override
    public ComponentRepository getComponentRepository() {
        return this.componentRepository;
    }

}

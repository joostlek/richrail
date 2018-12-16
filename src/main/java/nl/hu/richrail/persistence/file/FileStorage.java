package nl.hu.richrail.persistence.file;

import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.loggers.ComponentRepositoryLogger;
import nl.hu.richrail.persistence.loggers.TrainRepositoryLogger;
import nl.hu.richrail.persistence.memory.repositories.MemoryComponentRepository;
import nl.hu.richrail.persistence.memory.repositories.MemoryTrainRepository;

public class FileStorage implements StorageMethod {

    private final FileConfig config;

    private final TrainRepository trainRepository;

    private final ComponentRepository componentRepository;

    public FileStorage(FileConfig config) {
        this.config = config;
        this.trainRepository = new TrainRepositoryLogger(new FileTrainRepository(new FileFactory(config), new MemoryTrainRepository()));
        this.componentRepository = new ComponentRepositoryLogger(new FileComponentRepository(new FileFactory(config), new MemoryComponentRepository()));
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

package nl.hu.richrail.persistence.file;

import com.google.gson.Gson;
import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.loggers.ComponentRepositoryLogger;
import nl.hu.richrail.persistence.loggers.TrainRepositoryLogger;

public class FileStorage implements StorageMethod {

    private final TrainRepository trainRepository;

    private final ComponentRepository componentRepository;

    public FileStorage(FileConfig config) {
        FileFactory fileFactory = new FileFactory(config);
        Gson gson = new Gson();

        this.trainRepository = new TrainRepositoryLogger(new FileTrainRepository(fileFactory, gson));
        this.componentRepository = new ComponentRepositoryLogger(new FileComponentRepository(fileFactory, gson));
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

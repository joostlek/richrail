package nl.hu.richrail.persistence.loggers;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainRepositoryLogger implements TrainRepository {

    private static final Logger logger = Logger.getLogger(TrainRepositoryLogger.class.getName());

    private final TrainRepository repository;

    public TrainRepositoryLogger(TrainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Train getTrain(String name) {
        logger.log(Level.INFO, "Get train {0}", name);
        return this.repository.getTrain(name);
    }

    @Override
    public boolean hasTrain(String key) {
        logger.log(Level.INFO, "Has train {0}", key);
        return this.repository.hasTrain(key);
    }

    @Override
    public List<Train> getAllTrains() {
        logger.log(Level.INFO, "Get all trains");
        return this.repository.getAllTrains();
    }

    @Override
    public Train saveTrain(Train train) {
        logger.log(Level.INFO, "Save train {0}", train.getKey());
        return this.repository.saveTrain(train);
    }

    @Override
    public void deleteTrain(String name) {
        logger.log(Level.INFO, "Delete train {0}", name);
        this.repository.deleteTrain(name);
    }
}

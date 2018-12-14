package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainStorageLogger implements TrainStorageMethod {
    private TrainStorageMethod trainStorage;
    private Logger logger = Logger.getLogger(TrainStorageMethod.class.getName());

    public TrainStorageLogger(TrainStorageMethod trainStorage) {
        this.trainStorage = trainStorage;
    }

    @Override
    public Train getTrain(String name) {
        logger.log(Level.INFO, "Get train {0}", name);
        return trainStorage.getTrain(name);
    }

    @Override
    public List<Train> getAllTrains() {
        logger.log(Level.INFO, "Get all trains");
        return trainStorage.getAllTrains();
    }

    @Override
    public void saveTrain(Train train) {
        logger.log(Level.INFO, "Save train {0}", train.getId());
        trainStorage.saveTrain(train);
    }

    @Override
    public void deleteTrain(String name) {
        logger.log(Level.INFO, "Delete train {0}", name);
        trainStorage.deleteTrain(name);
    }
}

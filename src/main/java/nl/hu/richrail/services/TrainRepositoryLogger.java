package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainRepositoryLogger implements TrainRepositoryInterface {
    private TrainRepositoryInterface trainRepository;
    private Logger logger = Logger.getLogger("Train repository");

    public TrainRepositoryLogger(TrainRepositoryInterface trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public Train getTrain(String name) {
        logger.log(Level.INFO, String.format("Get train %s", name));
        return trainRepository.getTrain(name);
    }

    @Override
    public List<Train> getTrains() {
        logger.log(Level.INFO, "Get all trains");
        return trainRepository.getTrains();
    }

    @Override
    public Train saveTrain(Train train) {
        logger.log(Level.INFO, String.format("Save train %s", train.getId()));
        return trainRepository.saveTrain(train);
    }

    @Override
    public boolean deleteTrain(String name) {
        logger.log(Level.INFO, String.format("Delete train %s", name));
        return trainRepository.deleteTrain(name);
    }
}

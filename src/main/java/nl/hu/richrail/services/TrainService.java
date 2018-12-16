package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.persistence.TrainRepository;

public class TrainService {

    private static final int TRAIN_NAME_MAX_LENGTH = 20;

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train createTrain(String key) throws TrainServiceException {
        if (key == null || key.isEmpty()) {
            throw new TrainServiceException("The given train name is empty.");
        }

        if (key.length() > TRAIN_NAME_MAX_LENGTH) {
            throw new TrainServiceException(String.format("The given train name is too long (%d > %d).", key.length(), TRAIN_NAME_MAX_LENGTH));
        }

        if (this.trainRepository.hasTrain(key)) {
            throw new TrainServiceException(String.format("A train with the name '%s' does already exist.", key));
        }

        return this.trainRepository.saveTrain(new Train(key));
    }

    public void deleteTrain(String key) throws TrainServiceException {
        if (key == null || key.isEmpty()) {
            throw new TrainServiceException("The given train name is empty.");
        }

        this.trainRepository.deleteTrain(key);
    }
}

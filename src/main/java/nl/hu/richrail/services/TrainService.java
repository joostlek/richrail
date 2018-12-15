package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.persistence.TrainRepository;

public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train createTrain(String name) throws TrainServiceException {
        if (this.trainRepository.hasTrain(name)) {
            throw new TrainServiceException(String.format("A train with the name '%s' does already exist.", name));
        }

        return this.trainRepository.saveTrain(new Train(name));
    }

}

package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilderFactory;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;
import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.TrainRepository;

public class TrainService {

    private static final int KEY_MAX_LENGTH = 20;

    private final TrainRepository trainRepository;

    private final ComponentRepository componentRepository;

    public TrainService(TrainRepository trainRepository, ComponentRepository componentRepository) {
        this.trainRepository = trainRepository;
        this.componentRepository = componentRepository;
    }

    public Train createTrain(String key) throws TrainServiceException {
        if (key == null || key.isEmpty()) {
            throw new TrainServiceException("De opgegeven trein naam is leeg.");
        }

        if (key.length() > KEY_MAX_LENGTH) {
            throw new TrainServiceException(String.format("De opgegeven trein naam is te lang (%d > %d).", key.length(), KEY_MAX_LENGTH));
        }

        if (this.trainRepository.hasTrain(key)) {
            throw new TrainServiceException(String.format("Er bestaat al een trein met de naam '%s'.", key));
        }

        return this.trainRepository.saveTrain(new Train(key));
    }

    public void deleteTrain(String key) throws TrainServiceException {
        if (key == null || key.isEmpty()) {
            throw new TrainServiceException("De opgegeven trein naam is leeg.");
        }

        this.trainRepository.deleteTrain(key);
    }

    public void createComponent(String trainKey, String key, RollingComponentType type, int seats) throws TrainServiceException {
        if (!this.trainRepository.hasTrain(trainKey)) {
            throw new TrainServiceException(String.format("Er bestaat geen trein met de naam '%s'.", trainKey));
        }

        if (key == null || key.isEmpty()) {
            throw new TrainServiceException("De opgegeven wagon naam is leeg.");
        }

        if (key.length() > KEY_MAX_LENGTH) {
            throw new TrainServiceException(String.format("De opgegeven wagon naam is te lang (%d > %d).", key.length(), KEY_MAX_LENGTH));
        }

        if (seats < 0) {
            throw new TrainServiceException("Een wagon mag niet een negatieve aantal stoelen hebben.");
        }

        if (this.componentRepository.hasComponent(key)) {
            throw new TrainServiceException(String.format("Er bestaat al een wagon met de naam '%s'.", key));
        }

        RollingComponentBuilder componentBuilder = new RollingComponentBuilderFactory(type).getComponentBuilder();
        RollingComponent component = componentBuilder
                .setTrainKey(trainKey)
                .setKey(key)
                .setSeats(seats)
                .build();

        this.componentRepository.saveComponent(component);
    }

}

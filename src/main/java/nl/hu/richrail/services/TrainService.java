package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilderFactory;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;
import nl.hu.richrail.exceptions.TrainNotFoundException;
import nl.hu.richrail.exceptions.TrainServiceException;
import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.TrainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public List<Train> getTrainsWithComponents() {
        Map<String, Train> trains = this.trainRepository.getAllTrains().stream().collect(Collectors.toMap(Train::getKey, Function.identity()));
        List<RollingComponent> components = this.componentRepository.getAllComponents();

        for (RollingComponent component : components) {
            if (component.getTrainKey() != null) {
                Train train = trains.get(component.getTrainKey());
                if (train != null) {
                    train.addComponent(component);
                }
            }
        }

        return new ArrayList<>(trains.values());
    }

    public void createComponent(String trainKey, String key, RollingComponentType type, int seats) throws TrainServiceException {
        if (trainKey != null && !this.trainRepository.hasTrain(trainKey)) {
            throw new TrainNotFoundException(trainKey);
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

        this.componentRepository.insertComponent(component);
    }

    public int getTrainSeatCount(String trainKey) throws TrainServiceException {
        if (!this.trainRepository.hasTrain(trainKey)) {
            throw new TrainNotFoundException(trainKey);
        }

        return this.componentRepository
                .getComponentsByTrainKey(trainKey)
                .stream()
                .mapToInt(RollingComponent::getSeats)
                .sum();
    }

    public int getComponentSeatCount(String componentKey) throws TrainServiceException {
        if (!this.componentRepository.hasComponent(componentKey)) {
            throw new TrainServiceException(String.format("Er bestaat geen wagon met de naam '%s'.", componentKey));
        }

        return this.componentRepository.getComponent(componentKey).getSeats();
    }

    public boolean removeTrain(String trainKey) {
        if (!this.trainRepository.hasTrain(trainKey)) {
            return false;
        }

        this.trainRepository.deleteTrain(trainKey);
        return true;
    }

    public boolean removeComponent(String componentKey) {
        if (!this.componentRepository.hasComponent(componentKey)) {
            return false;
        }

        this.componentRepository.deleteComponent(componentKey);
        return true;
    }

    public void addComponentToTrain(String trainKey, String componentKey) throws TrainServiceException {
        if (!this.trainRepository.hasTrain(trainKey)) {
            throw new TrainNotFoundException(trainKey);
        }

        if (!this.componentRepository.hasComponent(componentKey)) {
            throw new TrainServiceException(String.format("Er bestaat geen wagon met de naam '%s'.", componentKey));
        }

        this.componentRepository.updateComponentTrainKey(componentKey, trainKey);
    }

    public boolean removeComponentFromTrain(String trainKey, String componentKey) throws TrainServiceException {
        if (!this.trainRepository.hasTrain(trainKey)) {
            throw new TrainNotFoundException(trainKey);
        }

        List<RollingComponent> components = this.componentRepository.getComponentsByTrainKey(trainKey);

        for (RollingComponent component : components) {
            if (component.getKey().equalsIgnoreCase(componentKey)) {
                this.componentRepository.removeComponentTrainKey(componentKey);
                return true;
            }
        }

        return false;
    }

}

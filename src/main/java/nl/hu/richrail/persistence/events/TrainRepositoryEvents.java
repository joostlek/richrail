package nl.hu.richrail.persistence.events;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;

import java.util.List;

public class TrainRepositoryEvents implements TrainRepository {

    private final TrainRepository repository;

    private final EventManager eventManager;

    public TrainRepositoryEvents(TrainRepository repository) {
        this.repository = repository;
        this.eventManager = new EventManager("save", "delete");
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public Train saveTrain(Train train) {
        Train savedTrain = this.repository.saveTrain(train);
        this.eventManager.notify("save");
        return savedTrain;
    }

    @Override
    public void deleteTrain(String key) {
        this.repository.deleteTrain(key);
        this.eventManager.notify("delete");
    }

    @Override
    public Train getTrain(String key) {
        return this.repository.getTrain(key);
    }

    @Override
    public boolean hasTrain(String key) {
        return this.repository.hasTrain(key);
    }

    @Override
    public List<Train> getAllTrains() {
        return this.repository.getAllTrains();
    }

}

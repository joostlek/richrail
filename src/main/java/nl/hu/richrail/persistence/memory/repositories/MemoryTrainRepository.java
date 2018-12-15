package nl.hu.richrail.persistence.memory.repositories;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MemoryTrainRepository implements TrainRepository {

    private final Dictionary<String, Train> trainMap;

    public MemoryTrainRepository() {
        this.trainMap = new Hashtable<>();
    }

    @Override
    public Train saveTrain(Train train) {
        return this.trainMap.put(train.getKey(), train);
    }

    @Override
    public void deleteTrain(String key) {
        this.trainMap.remove(key);
    }

    @Override
    public Train getTrain(String key) {
        return this.trainMap.get(key);
    }

    @Override
    public boolean hasTrain(String key) {
        return this.trainMap.get(key) != null;
    }

    @Override
    public List<Train> getAllTrains() {
        return Collections.list(trainMap.elements());
    }

}

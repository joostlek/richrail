package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;

import java.util.ArrayList;
import java.util.List;

public class TrainFileStorage implements TrainStorageMethod {
    @Override
    public void saveTrain(Train train) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteTrain(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Train getTrain(String key) {
        return null;
    }

    @Override
    public List<Train> getAllTrains() {
        return new ArrayList<>();
    }

    @Override
    public boolean open() {
        return false;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException();
    }
}

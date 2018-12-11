package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;

import java.util.List;

public class TrainRepository implements TrainRepositoryInterface {

    @Override
    public Train getTrain(String name) {
        return null;
    }

    @Override
    public List<Train> getTrains() {
        return null;
    }

    @Override
    public Train saveTrain(Train train) {
        return null;
    }

    @Override
    public boolean deleteTrain(String name) {
        return false;
    }
}

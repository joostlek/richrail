package nl.hu.richrail.persistence.file;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;

import java.util.List;

public class FileTrainRepository implements TrainRepository {

    @Override
    public Train saveTrain(Train train) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteTrain(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Train getTrain(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasTrain(String key) {
        return false;
    }

    @Override
    public List<Train> getAllTrains() {
        throw new UnsupportedOperationException();
    }

}

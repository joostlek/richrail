package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;

import java.util.List;

public interface TrainRepository {

    void saveTrain(Train train);

    void deleteTrain(String key);

    Train getTrain(String key);

    List<Train> getAllTrains();

}

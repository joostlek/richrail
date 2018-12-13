package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;

import java.util.List;

public interface StorageMethod {

    void saveTrain();

    void deleteTrain(Train train);

    Train getTrain(int id);

    List<Train> getAllTrains();

}

package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;

import java.util.List;

public interface TrainServiceInterface {
    Train getTrain(String name);

    List<Train> getTrains();

    Train saveTrain(Train train);

    boolean deleteTrain(String name);
}

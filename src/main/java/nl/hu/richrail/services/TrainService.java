package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;

public interface TrainService {
    Train getTrain(String name);
    List<Train> getTrains();
    boolean createTrain(String name);
    boolean removeTrain(String id);

    RollingComponent getRollingComponentFromTrain(String trainName, int position);
    List<RollingComponent> getRollingComponentsFromTrain(String trainName);
    boolean addRollingComponentToTrain(String trainName, RollingComponent rollingComponent);
    boolean removeRollingComponentFromTrain(String trainName, RollingComponent rollingComponent);

    RollingComponent getRollingComponent(String id);
    List<RollingComponent> getRollingComponents();
    boolean createRollingComponentLocomotive(String id, boolean hasCoals);
    boolean createRollingComponentWagon(String id, int seatPlaces, int standingPlaces);
    boolean removeRollingComponent(String id);
}

package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;

public interface TrainServiceInterface {
    Train getTrain(String id);
    List<Train> getTrains();
    boolean createTrain(String id);
    boolean removeTrain(String id);
    int getTotalNumSeats(String id);
    String getTrainsString();

    RollingComponent getRollingComponentFromTrain(String trainId, String rollingComponentId);
    List<RollingComponent> getRollingComponentsFromTrain(String trainId);
    boolean addRollingComponentToTrain(String trainId, RollingComponent rollingComponent);
    boolean removeRollingComponentFromTrain(String trainId, RollingComponent rollingComponent);

    RollingComponent getRollingComponent(String id);
    List<RollingComponent> getRollingComponents();
    boolean createRollingComponentLocomotive(String id);
    boolean createRollingComponentWagon(String id, int numSeats);
    boolean removeRollingComponent(String id);
    String getRollingComponentsString();
}

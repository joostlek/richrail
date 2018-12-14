package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.TrainFacade;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentFacade;

import java.util.List;

public class TrainService implements TrainServiceInterface {
    private static TrainService instance;

    TrainFacade trainFacade = new TrainFacade();
    RollingComponentFacade rollingComponent = new RollingComponentFacade();

    @Override
    public Train getTrain(String id) {
        return trainFacade.getTrain(id);
    }

    @Override
    public List<Train> getTrains() {
        return trainFacade.getTrains();
    }

    @Override
    public boolean createTrain(String id) {
        return trainFacade.createTrain(id);
    }

    @Override
    public boolean removeTrain(String id) {
        return trainFacade.removeTrain(id);
    }

    @Override
    public int getTotalNumSeats(String id) {
        return trainFacade.getTotalNumSeats(id);
    }

    @Override
    public String getTrainsString() {
        return trainFacade.getTrainsString();
    }

    @Override
    public RollingComponent getRollingComponentFromTrain(String trainId, String rollingComponentId) {
        return trainFacade.getRollingComponentFromTrain(trainId, rollingComponentId);
    }

    @Override
    public List<RollingComponent> getRollingComponentsFromTrain(String trainId) {
        return trainFacade.getRollingComponentsFromTrain(trainId);
    }

    @Override
    public boolean addRollingComponentToTrain(String trainId, RollingComponent rollingComponent) {
        return trainFacade.addRollingComponentToTrain(trainId, rollingComponent);
    }

    @Override
    public boolean removeRollingComponentFromTrain(String trainId, RollingComponent rollingComponent) {
        return trainFacade.removeRollingComponentFromTrain(trainId, rollingComponent);
    }

    @Override
    public RollingComponent getRollingComponent(String id) {
        return rollingComponent.getRollingComponent(id);
    }

    @Override
    public List<RollingComponent> getRollingComponents() {
        return rollingComponent.getRollingComponents();
    }

    @Override
    public boolean createRollingComponentLocomotive(String id) {
        return rollingComponent.createRollingComponentLocomotive(id);
    }

    @Override
    public boolean createRollingComponentWagon(String id, int numSeats) {
        return rollingComponent.createRollingComponentWagon(id, numSeats);
    }

    @Override
    public boolean removeRollingComponent(String id) {
        return rollingComponent.removeRollingComponent(id);
    }

    @Override
    public String getRollingComponentsString() {
        return rollingComponent.getRollingComponentsString();
    }

    /*
     * Return trainfacade instance when DAO is not implemented
     */
    public static TrainService getInstance() {
        if (instance == null) {
            instance = new TrainService();
        }

        return instance;
    }
}

package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.ArrayList;
import java.util.List;

public class TrainFacade {
    private List<Train> trains = new ArrayList<>();

    public Train getTrain(String name) {
        for (Train train : trains) {
            if (train.getKey().equalsIgnoreCase(name)) {
                return train;
            }
        }

        return null;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public boolean createTrain(String name) {
        return trains.add(new Train(name));
    }

    public boolean createTrain(String name, RollingComponent rollingComponent) {
        return trains.add(new Train(name, rollingComponent));
    }

    public boolean createTrain(String name, List<RollingComponent> rollingComponents) {
        return trains.add(new Train(name, rollingComponents));
    }

    public boolean removeTrain(String key) {
        Train train = getTrain(key);
        return trains.remove(train);
    }

    /*
    public boolean addRollingComponent(String name, RollingComponent rollingComponent) {
        Train train = getTrain(name);
        return train.addTrainRollingComponent(rollingComponent);
    }

    public boolean removeRollingComponent(String name, RollingComponent rollingComponent) {
        Train train = getTrain(name);
        return train.removeTrainRollingComponent(rollingComponent);
    }
    */
}

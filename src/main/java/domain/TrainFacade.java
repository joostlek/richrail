package domain;

import domain.rollingcomponent.RollingComponent;

import java.util.ArrayList;
import java.util.List;

public class TrainFacade {
    // TODO: TrainRepositoryInterface implementation

    private List<Train> trains = new ArrayList<Train>();

    public Train getTrain(String name) {
        for (Train train : trains) {
            if (train.getName().equalsIgnoreCase(name)) {
                return train;
            }
        }

        return null;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public boolean createTrain(String name) {
        if (getTrain(name) != null) {
            return false;
        } else {
            trains.add(new Train(name));
            return true;
        }
    }

    public boolean createTrain(String name, RollingComponent rollingComponent) {
        return false;
    }

    public boolean createTrain(String name, List<RollingComponent> rollingComponents) {
        return false;
    }

    public boolean removeTrain(Train train) {
        return false;
    }
}

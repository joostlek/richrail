package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.type.Wagon;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String id;
    private List<RollingComponent> rollingComponents = new ArrayList<>();

    public Train(String name) {
        this.id = name;
    }

    public String getId() {
        return id;
    }

    public RollingComponent getRollingComponentFromTrain(String rollingComponentId) {
        TrainIterator trainIterator = createIterator();

        while (trainIterator.hasNext()) {
            RollingComponent rollingComponent = trainIterator.getNext();

            if (rollingComponent.getId().equals(rollingComponentId)) {
                return rollingComponent;
            }
        }

        return null;
    }

    public List<RollingComponent> getRollingComponentsFromTrain() {
        return rollingComponents;
    }

    public boolean addRollingComponentToTrain(RollingComponent rollingComponent) {
        return rollingComponents.add(rollingComponent);
    }

    public boolean removeRollingComponentFromTrain(RollingComponent rollingComponent) {
        return rollingComponents.remove(rollingComponent);
    }

    public int getTotalNumSeats() {
        TrainIterator trainIterator = createIterator();
        int totalNumSeats = 0;

        while (trainIterator.hasNext()) {
            RollingComponent rollingComponent = trainIterator.getNext();

            if (rollingComponent instanceof Wagon) {
                totalNumSeats += ((Wagon) rollingComponent).getSeats();
            }
        }

        return totalNumSeats;
    }

    public TrainIterator createIterator() {
        return new TrainIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Train " + id);

        if (rollingComponents.size() > 0) {
            stringBuilder.append(" with " + rollingComponents.size() + " rollingcomponents");
        }

        return stringBuilder.toString();
    }
}

package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.type.Wagon;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String key;
    private List<RollingComponent> rollingComponents = new ArrayList<>();

    public Train(String name) {
        this.key = name;
    }

    public Train(String name, RollingComponent rollingComponent) {
        this(name);
        rollingComponents.add(rollingComponent);
    }

    public Train(String name, List<RollingComponent> rollingComponents) {
        this(name);
        this.rollingComponents = rollingComponents;
    }

    public String getKey() {
        return key;
    }

    public RollingComponent getRollingComponentFromTrain(int position) {
        return rollingComponents.get(position);
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

    public int getTotalSeatPlaces() {
        TrainIterator trainIterator = createIterator();
        int totalSeatPlaces = 0;

        while (trainIterator.hasNext()) {
            RollingComponent rollingComponent = trainIterator.getNext();
            if (rollingComponent instanceof Wagon) {
                totalSeatPlaces += ((Wagon) rollingComponent).getSeatPlaces();
            }
        }

        return totalSeatPlaces;
    }

    public int getTotalStandingPlaces() {
        TrainIterator trainIterator = createIterator();
        int totalStandingPlaces = 0;

        while (trainIterator.hasNext()) {
            RollingComponent rollingComponent = trainIterator.getNext();
            if (rollingComponent instanceof Wagon) {
                totalStandingPlaces += ((Wagon) rollingComponent).getStandingPlaces();
            }
        }

        return totalStandingPlaces;
    }

    public TrainIterator createIterator() {
        return new TrainIterator(this);
    }

    @Override
    public String toString() {
        return "Train \"" + key + "\" with " + rollingComponents.size() + " rollingcomponents.";
    }
}

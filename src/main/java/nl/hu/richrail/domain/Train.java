package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

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

    public RollingComponent getTrainRollingComponent(String key) {
        TrainIterator trainIterator = createIterator();
        while (trainIterator.hasNext()) {
            RollingComponent rollingComponent = trainIterator.getNext();
            if (rollingComponent.getKey().equalsIgnoreCase(key)) {
                return rollingComponent;
            }
        }

        return null;
    }

    public List<RollingComponent> getTrainRollingComponents() {
        return rollingComponents;
    }

    public boolean addTrainRollingComponent(RollingComponent rollingComponent) {
        return rollingComponents.add(rollingComponent);
    }

    public boolean removeTrainRollingComponent(String key) {
        RollingComponent rollingComponent = getTrainRollingComponent(key);
        return rollingComponents.remove(rollingComponent);
    }

    public TrainIterator createIterator() {
        return new TrainIterator(this);
    }
}

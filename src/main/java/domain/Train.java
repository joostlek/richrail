package domain;

import domain.rollingcomponent.RollingComponent;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String name;
    private List<RollingComponent> rollingComponents = new ArrayList<RollingComponent>();

    public Train(String name) {
        this.name = name;
    }

    public Train(String name, RollingComponent rollingComponent) {
        this(name);
        rollingComponents.add(rollingComponent);
    }

    public Train(String name, List<RollingComponent> rollingComponents) {
        this(name);
        this.rollingComponents = rollingComponents;
    }

    public String getName() {
        return name;
    }

    /*
    public TrainIterator<RollingComponent> getIterator() {
        return null;
    }
    */

    public List<RollingComponent> getTrainRollingComponents() {
        return rollingComponents;
    }

    public void addTrainRollingComponent(RollingComponent rollingComponent) {
        rollingComponents.add(rollingComponent);
    }

    public void removeTrainRollingComponent(RollingComponent rollingComponent) {
        rollingComponents.remove(rollingComponent);
    }


}

package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.type.Wagon;

import java.util.*;

public class Train implements Iterable<RollingComponent> {

    private final String key;

    private final Dictionary<String, RollingComponent> componentMap;

    public Train(String key) {
        this.key = key;
        this.componentMap = new Hashtable<>();
    }

    public String getKey() {
        return key;
    }

    public RollingComponent findComponent(String key) {
        return this.componentMap.get(key);
    }

    public List<RollingComponent> getAllComponents() {
        return Collections.list(this.componentMap.elements());
    }

    public void addComponent(RollingComponent component) {
        this.componentMap.put(component.getKey(), component);
    }

    public void removeComponent(RollingComponent component) {
        this.componentMap.remove(component.getKey());
    }

    public void removeComponent(String key) {
        this.componentMap.remove(key);
    }

    public int countSeats() {
        int totalSeats = 0;

        for (RollingComponent component : this) {
            totalSeats += component.getSeats();
        }

        return totalSeats;
    }

    @Override
    public Iterator<RollingComponent> iterator() {
        return new TrainIterator(this);
    }

    @Override
    public String toString() {
        return "Train{" +
                "key='" + key + '\'' +
                ", componentMap=" + componentMap +
                '}';
    }

}

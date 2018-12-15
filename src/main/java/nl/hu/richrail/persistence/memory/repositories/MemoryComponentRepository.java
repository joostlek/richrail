package nl.hu.richrail.persistence.memory.repositories;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.persistence.ComponentRepository;

import java.util.*;

public class MemoryComponentRepository implements ComponentRepository {

    private final Dictionary<String, RollingComponent> componentsMap;

    public MemoryComponentRepository() {
        this.componentsMap = new Hashtable<>();
    }

    @Override
    public void saveComponent(RollingComponent component) {
        this.componentsMap.put(component.getKey(), component);
    }

    @Override
    public void deleteComponent(String key) {
        this.componentsMap.remove(key);
    }

    @Override
    public RollingComponent getComponent(String key) {
        return this.componentsMap.get(key);
    }

    @Override
    public List<RollingComponent> getAllComponents() {
        return Collections.list(this.componentsMap.elements());
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String key) {
        throw new UnsupportedOperationException();
    }

}

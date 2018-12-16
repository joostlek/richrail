package nl.hu.richrail.persistence.events;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.persistence.ComponentRepository;

import java.util.List;

public class ComponentRepositoryEvents implements ComponentRepository {

    private final ComponentRepository repository;

    public ComponentRepositoryEvents(ComponentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveComponent(RollingComponent component) {
        this.repository.saveComponent(component);
    }

    @Override
    public void deleteComponent(String key) {
        this.repository.deleteComponent(key);
    }

    @Override
    public RollingComponent getComponent(String key) {
        return this.repository.getComponent(key);
    }

    @Override
    public List<RollingComponent> getAllComponents() {
        return this.repository.getAllComponents();
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String key) {
        return this.repository.getComponentsByTrainKey(key);
    }
}

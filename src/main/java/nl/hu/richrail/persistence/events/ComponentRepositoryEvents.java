package nl.hu.richrail.persistence.events;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.persistence.ComponentRepository;

import java.util.List;

public class ComponentRepositoryEvents implements ComponentRepository {

    private final ComponentRepository repository;

    private final EventManager eventManager;

    public ComponentRepositoryEvents(ComponentRepository repository) {
        this.repository = repository;
        this.eventManager = new EventManager("save", "update", "delete");
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public void insertComponent(RollingComponent component) {
        this.repository.insertComponent(component);
        this.eventManager.notify("save");
    }

    @Override
    public void updateComponentTrainKey(String key, String trainKey) {
        this.repository.updateComponentTrainKey(key, trainKey);
        this.eventManager.notify("update");
    }

    @Override
    public void removeComponentTrainKey(String key) {
        this.repository.removeComponentTrainKey(key);
        this.eventManager.notify("update");
    }

    @Override
    public void deleteComponent(String key) {
        this.repository.deleteComponent(key);
        this.eventManager.notify("delete");
    }

    @Override
    public RollingComponent getComponent(String key) {
        return this.repository.getComponent(key);
    }

    @Override
    public boolean hasComponent(String key) {
        return this.repository.hasComponent(key);
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

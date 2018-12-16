package nl.hu.richrail.persistence.loggers;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.persistence.ComponentRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComponentRepositoryLogger implements ComponentRepository {

    private static final Logger logger = Logger.getLogger(ComponentRepositoryLogger.class.getName());

    private ComponentRepository repository;

    public ComponentRepositoryLogger(ComponentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insertComponent(RollingComponent component) {
        logger.log(Level.INFO, "Save component {0}", component.getKey());
        this.repository.insertComponent(component);
    }

    @Override
    public void updateComponentTrainKey(String key, String trainKey) {
        logger.log(Level.INFO, String.format("Update component %s to train key %s", key, trainKey));
        this.repository.updateComponentTrainKey(key, trainKey);
    }

    @Override
    public void removeComponentTrainKey(String key) {
        logger.log(Level.INFO, String.format("Remove component %s train key", key));
        this.repository.removeComponentTrainKey(key);
    }

    @Override
    public void deleteComponent(String key) {
        logger.log(Level.INFO, "Delete component {0}", key);
        this.repository.deleteComponent(key);
    }

    @Override
    public RollingComponent getComponent(String key) {
        logger.log(Level.INFO, "Get component {0}", key);
        return this.repository.getComponent(key);
    }

    @Override
    public boolean hasComponent(String key) {
        logger.log(Level.INFO, "Has component {0}", key);
        return this.repository.hasComponent(key);
    }

    @Override
    public List<RollingComponent> getAllComponents() {
        logger.log(Level.INFO, "Get all components");
        return this.repository.getAllComponents();
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String key) {
        logger.log(Level.INFO, "Get all components from {0}", key);
        return this.repository.getComponentsByTrainKey(key);
    }

}

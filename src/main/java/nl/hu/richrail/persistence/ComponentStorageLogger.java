package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComponentStorageLogger implements StorageMethod {
    private StorageMethod componentStorage;
    private Logger logger = Logger.getLogger(ComponentStorageLogger.class.getName());

    public ComponentStorageLogger(StorageMethod componentStorage) {
        this.componentStorage = componentStorage;
    }

    @Override
    public void saveComponent(RollingComponent rollingComponent) {
        this.logger.log(Level.INFO, "Save component {0}", rollingComponent.getId());
        this.componentStorage.saveComponent(rollingComponent);
    }

    @Override
    public void deleteComponent(String key) {
        this.logger.log(Level.INFO, "Delete component {0}", key);
        this.componentStorage.deleteComponent(key);
    }

    @Override
    public RollingComponent getComponent(String key) {
        this.logger.log(Level.INFO, "Get component {0}", key);
        return this.componentStorage.getComponent(key);
    }

    @Override
    public List<RollingComponent> getAllComponents() {
        this.logger.log(Level.INFO, "Get all components");
        return this.componentStorage.getAllComponents();
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String key) {
        this.logger.log(Level.INFO, "Get all components from {0}", key);
        return this.componentStorage.getComponentsByTrainKey(key);
    }
}

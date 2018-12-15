package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;

public interface StorageMethod {
    void saveComponent(RollingComponent rollingComponent);

    void deleteComponent(String key);

    RollingComponent getComponent(String key);

    List<RollingComponent> getAllComponents();

    List<RollingComponent> getComponentsByTrainKey(String key);
}

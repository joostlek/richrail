package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;

public interface ComponentRepository {

    void insertComponent(RollingComponent component);

    void updateComponentTrainKey(String key, String trainKey);

    void removeComponentTrainKey(String key);

    void deleteComponent(String key);

    RollingComponent getComponent(String key);

    boolean hasComponent(String key);

    List<RollingComponent> getAllComponents();

    List<RollingComponent> getComponentsByTrainKey(String key);

}

package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;

public interface ComponentRepository {

    void saveComponent(RollingComponent component);

    void deleteComponent(String key);

    RollingComponent getComponent(String key);

    List<RollingComponent> getAllComponents();

    List<RollingComponent> getComponentsByTrainKey(String key);

}

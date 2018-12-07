package nl.hu.richrail.domain.rollingcomponent;

import nl.hu.richrail.domain.rollingcomponent.type.LocomotiveBuilder;
import nl.hu.richrail.domain.rollingcomponent.type.WagonBuilder;

import java.util.ArrayList;
import java.util.List;

public class RollingComponentFacade {
    private List<RollingComponent> rollingComponents = new ArrayList<>();

    LocomotiveBuilder locomotiveBuilder = new LocomotiveBuilder();
    WagonBuilder wagonBuilder = new WagonBuilder();

    public RollingComponent getRollingComponent(String key) {
        for (RollingComponent rollingComponent : rollingComponents) {
            if (rollingComponent.getKey().equalsIgnoreCase(key)) {
                return rollingComponent;
            }
        }

        return null;
    }

    public List<RollingComponent> getRollingComponents() {
        return rollingComponents;
    }

    public boolean createRollingComponentLocomotive(String key, String imagePath, boolean hasCoals) {
        locomotiveBuilder.setKey(key);
        locomotiveBuilder.setImagePath(imagePath);
        locomotiveBuilder.setLocomotiveHasCoals(hasCoals);
        return rollingComponents.add(locomotiveBuilder.getBuildResult());
    }

    public boolean createRollingComponentWagon(String key, String imagePath, int seatPlaces, int standingPlaces) {
        wagonBuilder.setKey(key);
        wagonBuilder.setImagePath(imagePath);
        wagonBuilder.setSeatPlaces(seatPlaces);
        wagonBuilder.setStandingPlaces(standingPlaces);
        return rollingComponents.add(wagonBuilder.getBuildResult());
    }

    public boolean removeRollingComponent(String key) {
        RollingComponent rollingComponent = getRollingComponent(key);
        return rollingComponents.remove(rollingComponent);
    }
}

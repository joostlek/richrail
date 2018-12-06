package domain.rollingcomponent;

import domain.rollingcomponent.type.Locomotive;
import domain.rollingcomponent.type.LocomotiveBuilder;
import domain.rollingcomponent.type.Wagon;
import domain.rollingcomponent.type.WagonBuilder;

import java.util.ArrayList;
import java.util.List;

public class RollingComponentFacade {
    private List<RollingComponent> rollingComponents = new ArrayList<RollingComponent>();

    LocomotiveBuilder locomotiveBuilder = new LocomotiveBuilder();
    WagonBuilder wagonBuilder = new WagonBuilder();

    public List<RollingComponent> getRollingComponents() {
        return rollingComponents;
    }

    public Locomotive createRollingComponentLocomotive(String imagePath, boolean hasCoals) {
        locomotiveBuilder.setImagePath(imagePath);
        locomotiveBuilder.setLocomotiveHasCoals(hasCoals);
        return locomotiveBuilder.getBuildResult();
    }

    public Wagon createRollingComponentWagon(String imagePath, int seatPlaces, int standingPlaces) {
        wagonBuilder.setImagePath(imagePath);
        wagonBuilder.setSeatPlaces(seatPlaces);
        wagonBuilder.setStandingPlaces(standingPlaces);
        return wagonBuilder.getBuildResult();
    }

    public boolean removeRollingComponent(RollingComponent rollingComponent) {
        return rollingComponents.remove(rollingComponent);
    }
}

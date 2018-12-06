package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Locomotive extends RollingComponent {
    private boolean hasCoals;

    public Locomotive(String imagePath, boolean hasCoals) {
        super(imagePath);
        this.hasCoals = hasCoals;
    }

    public boolean getLocomotiveHasCoals() {
        return hasCoals;
    }

    public Wagon clone() {
        return null;
    }
}

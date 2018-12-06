package domain.rollingcomponent.type;

import domain.rollingcomponent.RollingComponent;

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

package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Locomotive extends RollingComponent {
    private boolean hasCoals;

    public Locomotive(String key, String imagePath, boolean hasCoals) {
        super(key, imagePath);
        this.hasCoals = hasCoals;
    }

    public boolean getLocomotiveHasCoals() {
        return hasCoals;
    }

    @Override
    public RollingComponent clone() {
        return new Locomotive(this.getKey(), this.getImagePath(), hasCoals);
    }

    @Override
    public String toString() {
        return "Locomotive \"" + this.getKey() + "\" with has coals " + hasCoals + ".";
    }
}

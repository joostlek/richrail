package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class LocomotiveBuilder implements RollingComponentBuilder {
    private String key;
    private String imagePath;
    private boolean hasCoals;

    public void setKey(String key) {
        this.key = key;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setLocomotiveHasCoals(boolean hasCoals) {
        this.hasCoals = hasCoals;
    }

    public Locomotive getBuildResult() {
        return new Locomotive(key, imagePath, hasCoals);
    }
}

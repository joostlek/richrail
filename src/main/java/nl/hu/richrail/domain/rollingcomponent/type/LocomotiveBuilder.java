package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class LocomotiveBuilder implements RollingComponentBuilder {
    private String key;
    private String imagePath;
    private boolean hasCoals;

    public LocomotiveBuilder(String key, String imagePath) {
        this.key = key;
        this.imagePath = imagePath;
    }

    public void setLocomotiveHasCoals(boolean hasCoals) {
        this.hasCoals = hasCoals;
    }

    @Override
    public Locomotive getBuildResult() {
        return new Locomotive(key, imagePath, hasCoals);
    }
}

package domain.rollingcomponent.type;

import domain.rollingcomponent.RollingComponentBuilder;

public class LocomotiveBuilder implements RollingComponentBuilder {
    private String imagePath;
    private boolean hasCoals;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setLocomotiveHasCoals(boolean hasCoals) {
        this.hasCoals = hasCoals;
    }

    public Locomotive getBuildResult() {
        return new Locomotive(imagePath, hasCoals);
    }
}

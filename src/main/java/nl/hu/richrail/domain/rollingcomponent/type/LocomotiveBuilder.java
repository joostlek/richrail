package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class LocomotiveBuilder implements RollingComponentBuilder {
    private String id;
    private String imagePath;

    public LocomotiveBuilder(String id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    @Override
    public Locomotive getBuildResult() {
        return new Locomotive(id, imagePath);
    }
}

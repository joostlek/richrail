package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Locomotive implements RollingComponent {
    private String key;
    private String imagePath;
    private boolean hasCoals;

    public Locomotive(String key, String imagePath, boolean hasCoals) {
        this.key = key;
        this.imagePath = imagePath;
        this.hasCoals = hasCoals;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    public boolean getLocomotiveHasCoals() {
        return hasCoals;
    }
}

package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class LocomotiveBuilder implements RollingComponentBuilder {

    private String key;

    private String imagePath;

    @Override
    public RollingComponentBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public RollingComponentBuilder setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    @Override
    public RollingComponentBuilder setSeats(int seats) {
        throw new UnsupportedOperationException("Locomotive can not have seats.");
    }

    @Override
    public RollingComponent build() {
        return new Locomotive(this.key, this.imagePath);
    }

}

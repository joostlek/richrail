package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class LocomotiveBuilder implements RollingComponentBuilder {

    private String key;

    private String trainKey;

    @Override
    public RollingComponentBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public RollingComponentBuilder setSeats(int seats) {
        // Just ignore.
        return this;
    }

    @Override
    public RollingComponentBuilder setTrainKey(String trainKey) {
        this.trainKey = trainKey;
        return this;
    }

    @Override
    public RollingComponent build() {
        return new Locomotive(this.key, this.trainKey);
    }

}

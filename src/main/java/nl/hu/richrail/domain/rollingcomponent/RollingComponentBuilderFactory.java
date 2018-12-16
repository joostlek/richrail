package nl.hu.richrail.domain.rollingcomponent;

import nl.hu.richrail.domain.rollingcomponent.type.LocomotiveBuilder;
import nl.hu.richrail.domain.rollingcomponent.type.WagonBuilder;

public class RollingComponentBuilderFactory {

    private final RollingComponentType type;

    public RollingComponentBuilderFactory(RollingComponentType type) {
        this.type = type;
    }

    public RollingComponentBuilder getComponentBuilder() {
        switch (this.type) {
            case WAGON:
                return new WagonBuilder();

            case LOCOMOTIVE:
                return new LocomotiveBuilder();

            default:
                throw new IllegalArgumentException("Unknown type.");
        }
    }

}

package nl.hu.richrail.domain.rollingcomponent;

import nl.hu.richrail.domain.rollingcomponent.type.LocomotiveBuilder;
import nl.hu.richrail.domain.rollingcomponent.type.WagonBuilder;

public class RollingComponentBuilderFactory {
    public RollingComponentBuilder getComponentBuilder(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("WAGON")) {
            return new WagonBuilder();
        } else if (type.equalsIgnoreCase("LOCOMOTIVE")) {
            return new LocomotiveBuilder();
        }
        return null;
    }
}

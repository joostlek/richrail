package nl.hu.richrail.application.gui.items;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;

public class ComponentComboItem {

    private final String name;

    private final RollingComponentType value;

    public ComponentComboItem(String name, RollingComponentType value) {
        this.name = name;
        this.value = value;
    }

    public RollingComponentType getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

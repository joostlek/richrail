package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Locomotive extends RollingComponent {
    public Locomotive(String id, String imagePath) {
        super(id, imagePath);
    }

    @Override
    public RollingComponent clone() {
        return new Locomotive(this.getId(), this.getImagePath());
    }

    @Override
    public String toString() {
        return "Locomotive \"" + this.getId() + "\"";
    }
}

package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Locomotive extends RollingComponent {

    Locomotive(String key, String imagePath) {
        super(key, imagePath);
    }

    @Override
    public RollingComponent clone() {
        return new LocomotiveBuilder()
                .setKey(this.key)
                .setImagePath(this.imagePath)
                .build();
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "key='" + key + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}

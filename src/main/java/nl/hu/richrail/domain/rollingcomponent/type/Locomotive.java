package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Locomotive implements RollingComponent {

    private final String key;

    private final String imagePath;

    Locomotive(String key, String imagePath) {
        this.key = key;
        this.imagePath = imagePath;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public int getSeats() {
        return 0;
    }

    @Override
    public RollingComponent clone() {
        return new LocomotiveBuilder()
                .setKey(this.key)
                .setImagePath(this.imagePath)
                .build();
    }

    @Override
    public String getType() {
        return "Locomotive";
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "key='" + key + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}

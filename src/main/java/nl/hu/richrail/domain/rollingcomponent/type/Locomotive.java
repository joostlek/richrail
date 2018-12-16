package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;

public class Locomotive implements RollingComponent {

    private final String key;

    private String trainKey;

    Locomotive(String key, String trainKey) {
        this.key = key;
        this.trainKey = trainKey;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int getSeats() {
        return 0;
    }

    @Override
    public RollingComponent clone() {
        return new LocomotiveBuilder()
                .setKey(this.key)
                .setTrainKey(this.trainKey)
                .build();
    }

    @Override
    public RollingComponentType getType() {
        return RollingComponentType.Locomotive;
    }

    @Override
    public String getTrainKey() {
        return trainKey;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "key='" + key + '\'' +
                ", trainKey='" + trainKey + '\'' +
                '}';
    }

}

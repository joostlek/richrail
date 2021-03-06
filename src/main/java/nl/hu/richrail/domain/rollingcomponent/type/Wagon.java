package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;

public class Wagon implements RollingComponent {

    private final String key;

    private final int seats;

    private String trainKey;

    Wagon(String key, int seats, String trainKey) {
        this.key = key;
        this.seats = seats;
        this.trainKey = trainKey;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public RollingComponentType getType() {
        return RollingComponentType.WAGON;
    }

    @Override
    public String getTrainKey() {
        return trainKey;
    }

    @Override
    public void setTrainKey(String trainKey) {
        this.trainKey = trainKey;
    }

    @Override
    public String toString() {
        return "WAGON{" +
                "key='" + key + '\'' +
                ", seats=" + seats +
                ", trainKey='" + trainKey + '\'' +
                '}';
    }

}

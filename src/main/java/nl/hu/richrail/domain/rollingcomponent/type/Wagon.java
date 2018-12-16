package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Wagon implements RollingComponent {

    private final String key;

    private final String imagePath;

    private final int seats;

    private String trainKey;

    Wagon(String key, String imagePath, int seats, String trainKey) {
        this.key = key;
        this.imagePath = imagePath;
        this.seats = seats;
        this.trainKey = trainKey;
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
        return seats;
    }

    @Override
    public RollingComponent clone() {
        return new WagonBuilder()
                .setKey(this.key)
                .setImagePath(this.imagePath)
                .setSeats(this.seats)
                .build();
    }

    @Override
    public String getType() {
        return "Wagon";
    }

    @Override
    public String getTrainKey() {
        return trainKey;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "key='" + key + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", seats=" + seats +
                '}';
    }

}

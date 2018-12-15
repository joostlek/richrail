package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Wagon extends RollingComponent {

    private int seats;

    Wagon(String id, String imagePath, int seats) {
        super(id, imagePath);
        this.seats = seats;
    }

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
    public String toString() {
        return "Wagon{" +
                "key='" + key + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", seats=" + seats +
                '}';
    }

}

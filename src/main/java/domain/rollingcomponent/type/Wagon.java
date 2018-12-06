package domain.rollingcomponent.type;

import domain.rollingcomponent.RollingComponent;

public class Wagon extends RollingComponent {
    private int seatPlaces;
    private int standingPlaces;

    public Wagon(String imagePath, int seatPlaces, int StandingPlaces) {
        super(imagePath);
        this.seatPlaces = seatPlaces;
        this.standingPlaces = standingPlaces;
    }

    public int getSeatPlaces() {
        return seatPlaces;
    }

    public int getStandingPlaces() {
        return standingPlaces;
    }

    public Wagon clone() {
        return null;
    }
}

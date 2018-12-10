package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Wagon extends RollingComponent {
    private int seatPlaces;
    private int standingPlaces;

    public Wagon(String key, String imagePath, int seatPlaces, int standingPlaces) {
        super(key, imagePath);
        this.seatPlaces = seatPlaces;
        this.standingPlaces = standingPlaces;
    }

    public int getSeatPlaces() {
        return seatPlaces;
    }

    public int getStandingPlaces() {
        return standingPlaces;
    }

    @Override
    public RollingComponent clone() {
        return new Wagon(this.getKey(), this.getImagePath(), seatPlaces, standingPlaces);
    }

    @Override
    public String toString() {
        return "Wagon \"" + this.getKey() + "\" with " + seatPlaces + " seats and " + standingPlaces + " standing places.";
    }
}

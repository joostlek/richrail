package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Wagon implements RollingComponent {
    private String key;
    private String imagePath;
    private int seatPlaces;
    private int standingPlaces;

    public Wagon(String key, String imagePath, int seatPlaces, int StandingPlaces) {
        this.key = key;
        this.imagePath = imagePath;
        this.seatPlaces = seatPlaces;
        this.standingPlaces = standingPlaces;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    public int getSeatPlaces() {
        return seatPlaces;
    }

    public int getStandingPlaces() {
        return standingPlaces;
    }
}

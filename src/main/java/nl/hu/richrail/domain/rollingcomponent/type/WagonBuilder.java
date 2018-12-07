package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class WagonBuilder implements RollingComponentBuilder {
    private String key;
    private String imagePath;
    private int seatPlaces;
    private int standingPlaces;

    public void setKey(String key) {
        this.key = key;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setSeatPlaces(int seatPlaces) {
        this.seatPlaces = seatPlaces;
    }

    public void setStandingPlaces(int standingPlaces) {
        this.standingPlaces = standingPlaces;
    }

    public Wagon getBuildResult() {
        return new Wagon(key, imagePath, seatPlaces, standingPlaces);
    }
}

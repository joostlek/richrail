package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class WagonBuilder implements RollingComponentBuilder {
    private String id;
    private String imagePath;
    private int numSeats;

    public WagonBuilder(String id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    @Override
    public Wagon getBuildResult() {
        return new Wagon(id, imagePath, numSeats);
    }
}

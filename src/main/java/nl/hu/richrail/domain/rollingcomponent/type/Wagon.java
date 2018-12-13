package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

public class Wagon extends RollingComponent {
    private int numSeats;

    public Wagon(String id, String imagePath, int numSeats) {
        super(id, imagePath);
        this.numSeats = numSeats;
    }

    public int getNumSeats() {
        return numSeats;
    }

    @Override
    public RollingComponent clone() {
        return new Wagon(this.getId(), this.getImagePath(), numSeats);
    }

    @Override
    public String toString() {
        return "Wagon \"" + this.getId() + "\" with " + numSeats + " seats";
    }
}

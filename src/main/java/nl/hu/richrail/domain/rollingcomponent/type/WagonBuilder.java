package nl.hu.richrail.domain.rollingcomponent.type;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;

public class WagonBuilder implements RollingComponentBuilder {

    /**
     * 20 seats is the default, as per assignment requirements
     */
    private static final int DEFAULT_SEATS = 20;

    private String key;

    private String trainKey;

    private int seats = DEFAULT_SEATS;

    @Override
    public RollingComponentBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public RollingComponentBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public RollingComponentBuilder setTrainKey(String trainKey) {
        this.trainKey = trainKey;
        return this;
    }

    @Override
    public RollingComponent build() {
        return new Wagon(this.key, this.seats, this.trainKey);
    }

}

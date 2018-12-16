package nl.hu.richrail.domain.rollingcomponent;

public interface RollingComponentBuilder {

    RollingComponentBuilder setKey(String key);

    RollingComponentBuilder setSeats(int seats);

    RollingComponentBuilder setTrainKey(String trainKey);

    RollingComponent build();

}

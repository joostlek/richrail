package nl.hu.richrail.domain.rollingcomponent;

public interface RollingComponentBuilder {

    RollingComponentBuilder setKey(String key);

    RollingComponentBuilder setImagePath(String imagePath);

    RollingComponentBuilder setSeats(int seats);

    RollingComponent build();

}

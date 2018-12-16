package nl.hu.richrail.domain.rollingcomponent;

public interface RollingComponent {

    String getKey();

    int getSeats();

    RollingComponent clone();

    RollingComponentType getType();

    String getTrainKey();

}

package nl.hu.richrail.domain.rollingcomponent;

public interface RollingComponent {

    String getKey();

    int getSeats();

    RollingComponentType getType();

    String getTrainKey();

    void setTrainKey(String trainKey);

}

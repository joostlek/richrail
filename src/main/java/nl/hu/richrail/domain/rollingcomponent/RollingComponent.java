package nl.hu.richrail.domain.rollingcomponent;

public interface RollingComponent {

    String getKey();

    String getImagePath();

    int getSeats();

    RollingComponent clone();

}

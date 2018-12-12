package nl.hu.richrail.domain;

public interface RollingComponent {
    int getId();

    int getSeats();

    String getKey();

    void draw();
}

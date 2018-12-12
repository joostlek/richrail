package nl.hu.richrail.domain.rollingcomponent;

public abstract class RollingComponent {
    private String id;
    private String imagePath;

    public RollingComponent(String id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public abstract RollingComponent clone();
    public abstract String toString();
}

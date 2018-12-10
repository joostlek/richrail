package nl.hu.richrail.domain.rollingcomponent;

public abstract class RollingComponent {
    private String key;
    private String imagePath;

    public RollingComponent(String key, String imagePath) {
        this.key = key;
        this.imagePath = imagePath;
    }

    public String getKey() {
        return key;
    }

    public String getImagePath() {
        return imagePath;
    }

    public abstract RollingComponent clone();
    public abstract String toString();
}

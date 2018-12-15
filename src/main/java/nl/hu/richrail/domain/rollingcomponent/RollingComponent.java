package nl.hu.richrail.domain.rollingcomponent;

public abstract class RollingComponent implements Cloneable {

    protected String key;

    protected String imagePath;

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

    @Override
    public abstract RollingComponent clone();

}

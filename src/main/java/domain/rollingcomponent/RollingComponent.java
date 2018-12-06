package domain.rollingcomponent;

public abstract class RollingComponent {
    private int id;
    private String imagePath;

    public RollingComponent(String imagePath) {
        id = 0;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String imagePath() {
        return imagePath;
    }

    public abstract RollingComponent clone();
}

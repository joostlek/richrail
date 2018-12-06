package nl.hu.richrail.domain.rollingcomponent;

public interface RollingComponentBuilder {
    void setImagePath(String imagePath);
    RollingComponent getBuildResult();
}

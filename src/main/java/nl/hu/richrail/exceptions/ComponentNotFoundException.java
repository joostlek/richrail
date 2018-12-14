package nl.hu.richrail.exceptions;

public class ComponentNotFoundException extends RuntimeException {
    public ComponentNotFoundException(String key) {
        super(String.format("Component %s not found", key));
    }
}

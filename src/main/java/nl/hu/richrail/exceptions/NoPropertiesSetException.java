package nl.hu.richrail.exceptions;

public class NoPropertiesSetException extends RuntimeException {
    public NoPropertiesSetException() {
        super("app.properties or environment variables are empty");
    }
}

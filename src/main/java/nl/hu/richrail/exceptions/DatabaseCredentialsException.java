package nl.hu.richrail.exceptions;

public class DatabaseCredentialsException extends RuntimeException {
    public DatabaseCredentialsException() {
        super("Could not connect to database");
    }
}

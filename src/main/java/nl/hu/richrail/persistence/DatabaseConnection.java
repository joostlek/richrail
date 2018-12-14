package nl.hu.richrail.persistence;

import nl.hu.richrail.exceptions.DatabaseCredentialsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private DatabaseConnection() {
    }

    public static Connection getConnection(DatabaseConfig config) {
        try {
            return DriverManager.getConnection(config.host, config.username, config.password);
        } catch (SQLException e) {
            throw new DatabaseCredentialsException();
        }
    }
}

package nl.hu.richrail.persistence;

import nl.hu.richrail.exceptions.DatabaseCredentialsException;
import nl.hu.richrail.persistence.config.Config;
import nl.hu.richrail.persistence.config.DatabaseConfig;
import nl.hu.richrail.persistence.config.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
        try {
            DatabaseConfig configurator = new DatabaseProperties();
            Config config = configurator.getDatabaseConfig();
            this.connection = DriverManager.getConnection(config.getHostname(), config.getUsername(), config.getPassword());
            logger.log(Level.INFO, "Database connection initialized");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new DatabaseCredentialsException();
        }
    }

    Connection getConnection() {
        return connection;
    }

    static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

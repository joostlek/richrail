package nl.hu.richrail.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {

    private final DatabaseConfig config;

    public DatabaseConnectionFactory(DatabaseConfig config) {
        this.config = config;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(this.config.getUrl(), this.config.getUsername(), this.config.getPassword());
    }

}

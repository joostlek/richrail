package nl.hu.richrail.persistence;

import nl.hu.richrail.exceptions.DatabaseCredentialsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:" + System.getProperty("DB.HOST"), System.getProperty("DB.USER"), System.getProperty("DB.PASS"));
        } catch (SQLException e) {
            throw new DatabaseCredentialsException();
        }
    }
}

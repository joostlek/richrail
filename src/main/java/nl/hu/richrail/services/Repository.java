package nl.hu.richrail.services;

import java.sql.Connection;

public abstract class Repository {
    Connection getConnection() {
        return null;
    }
}

package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.exceptions.DatabaseCredentialsException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainDatabaseStorage implements TrainStorageMethod {

    private final Logger logger = Logger.getLogger(TrainDatabaseStorage.class.getName());

    private final DatabaseConfig config;

    private Connection connection;

    public TrainDatabaseStorage(DatabaseConfig config) {
        this.config = config;
    }

    @Override
    public void saveTrain(Train train) {
        try (PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO trains(key) VALUES (?)")) {
            stmt.setString(1, train.getId());
            stmt.execute();
            this.connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void deleteTrain(String key) {
        try (PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM trains WHERE key = ?")) {
            stmt.setString(1, key);
            stmt.execute();
            this.connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public Train getTrain(String key) {
        return new Train(key);
    }

    @Override
    public List<Train> getAllTrains() {
        ArrayList<Train> trains = new ArrayList<>();
        try (PreparedStatement stmt = this.connection.prepareStatement("SELECT key FROM trains");
             ResultSet result = stmt.executeQuery()) {
            while (result.next()) {
                String key = result.getString("KEY");
                Train train = new Train(key);
                trains.add(train);
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return trains;
    }

    @Override
    public boolean open() {
        try {
            this.connection = DriverManager.getConnection(config.host, config.username, config.password);
            return this.connection.isValid(3600);
        } catch (SQLException e) {
            throw new DatabaseCredentialsException();
        }
    }

    @Override
    public void close() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

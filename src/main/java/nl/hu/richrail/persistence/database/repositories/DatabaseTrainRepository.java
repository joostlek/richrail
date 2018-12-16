package nl.hu.richrail.persistence.database.repositories;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.database.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseTrainRepository implements TrainRepository {

    private static final Logger logger = Logger.getLogger(DatabaseTrainRepository.class.getName());

    private final DatabaseConnectionFactory connectionFactory;

    public DatabaseTrainRepository(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Train saveTrain(Train train) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO trains(`key`) VALUES (?)")) {
            stmt.setString(1, train.getKey());
            stmt.execute();

            connection.commit();

            return train;
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTrain(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM trains WHERE `key` = ?")) {
            stmt.setString(1, key);
            stmt.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public Train getTrain(String key) {
        if (this.hasTrain(key)) {
            return new Train(key);
        }
        return null;
    }

    @Override
    public boolean hasTrain(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT `key` FROM trains WHERE `key` = ?")) {

            stmt.setString(1, key);

            try (ResultSet result = stmt.executeQuery()) {
                return result.next();
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
            return false;
        }
    }

    @Override
    public List<Train> getAllTrains() {
        ArrayList<Train> trains = new ArrayList<>();

        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT `key` FROM trains");
             ResultSet result = statement.executeQuery()) {
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
}

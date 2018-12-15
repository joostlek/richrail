package nl.hu.richrail.persistence.database.repositories;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.exceptions.ComponentNotFoundException;
import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.database.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseComponentRepository implements ComponentRepository {

    private static final Logger logger = Logger.getLogger(DatabaseComponentRepository.class.getName());

    private final DatabaseConnectionFactory connectionFactory;

    public DatabaseComponentRepository(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void saveComponent(RollingComponent component) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO traincomponent(`key`, seats, train_key) VALUES (?, ?, NULL)")) {
            stmt.setString(1, component.getKey());
            //TODO: Add seats to rolling component
            stmt.setInt(2, 2);
            stmt.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void deleteComponent(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM traincomponent WHERE key = ?")) {
            stmt.setString(1, key);
            stmt.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public RollingComponent getComponent(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT `key`, seats, train_key FROM traincomponent WHERE `key` = ?")) {
            stmt.setString(1, key);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String componentKey = resultSet.getString("KEY");
                    int seats = resultSet.getInt("SEATS");
                    String componentTrain = resultSet.getString("TRAIN_KEY");
                } else {
                    throw new ComponentNotFoundException(key);
                }
            }

            return null;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ComponentNotFoundException(key);
        }
    }

    @Override
    public List<RollingComponent> getAllComponents() {
        return new ArrayList<>();
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String key) {
        return new ArrayList<>();
    }

}

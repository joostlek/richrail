package nl.hu.richrail.persistence.database.repositories;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilder;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentBuilderFactory;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;
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
    public void insertComponent(RollingComponent component) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO traincomponent(`key`, `seats`, `train_key`, `type`) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, component.getKey());
            stmt.setInt(2, component.getSeats());
            stmt.setString(3, component.getTrainKey());
            stmt.setString(4, component.getType().toString());
            stmt.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void updateComponentTrainKey(String key, String trainKey) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE traincomponent SET `train_key` = ? WHERE `key` = ?")) {
            stmt.setString(1, trainKey);
            stmt.setString(2, key);
            stmt.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void removeComponentTrainKey(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE traincomponent SET `train_key` = NULL WHERE `key` = ?")) {
            stmt.setString(1, key);
            stmt.execute();

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void deleteComponent(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM traincomponent WHERE `key` = ?")) {
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
             PreparedStatement stmt = connection.prepareStatement("SELECT `key`, `seats`, `train_key`, `type` FROM traincomponent WHERE `key` = ?")) {
            stmt.setString(1, key);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultToComponent(resultSet);
                }

                throw new ComponentNotFoundException(key);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ComponentNotFoundException(key);
        }
    }

    @Override
    public boolean hasComponent(String key) {
        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT `key` FROM traincomponent WHERE `key` = ?")) {

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
    public List<RollingComponent> getAllComponents() {
        ArrayList<RollingComponent> components = new ArrayList<>();

        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT `key`, `seats`, `train_key`, `type` FROM traincomponent");
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                components.add(resultToComponent(result));
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return components;
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String trainKey) {
        ArrayList<RollingComponent> components = new ArrayList<>();

        try (Connection connection = this.connectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT `key`, `seats`, `train_key`, `type` FROM traincomponent WHERE `train_key` = ?")) {
            statement.setString(1, trainKey);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    components.add(resultToComponent(result));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        return components;
    }

    // TODO (Joost): Refactor code below to a better location (or not..).
    private RollingComponent resultToComponent(ResultSet result) throws SQLException {
        String key = result.getString("KEY");
        int seats = result.getInt("SEATS");
        String trainKey = result.getString("TRAIN_KEY");
        RollingComponentType type = RollingComponentType.valueOf(result.getString("TYPE"));

        RollingComponentBuilder componentBuilder = new RollingComponentBuilderFactory(type).getComponentBuilder();
        return componentBuilder.setKey(key).setSeats(seats).setTrainKey(trainKey).build();
    }

}

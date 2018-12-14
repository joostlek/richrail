package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.exceptions.ComponentNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComponentDatabaseStorage implements ComponentStorageMethod {

    private final Logger logger = Logger.getLogger(ComponentDatabaseStorage.class.getName());

    public ComponentDatabaseStorage() {
    }

    @Override
    public void saveComponent(RollingComponent rollingComponent) {
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("INSERT INTO traincomponent(key, seats, train_key) VALUES (?, ?, NULL)")) {
            stmt.setString(1, rollingComponent.getId());
            //TODO: Add seats to rolling component
            stmt.setInt(2, 2);
            stmt.execute();
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void deleteComponent(String key) {
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("DELETE FROM traincomponent WHERE key = ?")) {
            stmt.setString(1, key);
            stmt.execute();
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public RollingComponent getComponent(String key) {
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT key, seats, train_key FROM traincomponent WHERE key = ?")) {
            stmt.setString(1, key);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String componentKey = resultSet.getString("KEY");
                    int sears = resultSet.getInt("SEATS");
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

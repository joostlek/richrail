package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainDatabaseStorage implements TrainStorageMethod {

    private final Logger logger = Logger.getLogger(TrainDatabaseStorage.class.getName());

    @Override
    public void saveTrain(Train train) {
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("INSERT INTO trains(key) VALUES (?)")) {
            stmt.setString(1, train.getId());
            stmt.execute();
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void deleteTrain(String key) {
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("DELETE FROM trains WHERE key = ?")) {
            stmt.setString(1, key);
            stmt.execute();
            DatabaseConnection.getInstance().getConnection().commit();
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
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT key FROM trains");
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
}

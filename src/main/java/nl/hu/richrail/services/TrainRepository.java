package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TrainRepository implements TrainRepositoryInterface {

    public TrainRepository() {
    }

    @Override
    public Train getTrain(String name) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
//            stmt.execute("SELECT * FROM ")
            stmt.close();
            connection.close();
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Train> getTrains() {
        return null;
    }

    @Override
    public Train saveTrain(Train train) {
        return null;
    }

    @Override
    public boolean deleteTrain(String name) {
        return false;
    }
}

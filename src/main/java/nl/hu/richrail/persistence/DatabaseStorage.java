package nl.hu.richrail.persistence;

import nl.hu.richrail.domain.Train;

import java.util.List;

public class DatabaseStorage implements StorageMethod {

    private final DatabaseConfig config;

    private final Object connection;

    public DatabaseStorage(DatabaseConfig config) {
        this.config = config;
        this.connection = null;
    }

    @Override
    public void saveTrain() {

    }

    @Override
    public void deleteTrain(Train train) {

    }

    @Override
    public Train getTrain(int id) {
        return null;
    }

    @Override
    public List<Train> getAllTrains() {
        return null;
    }
}

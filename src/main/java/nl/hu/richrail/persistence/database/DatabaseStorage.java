package nl.hu.richrail.persistence.database;

import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.database.repositories.DatabaseComponentRepository;
import nl.hu.richrail.persistence.database.repositories.DatabaseTrainRepository;

public class DatabaseStorage implements StorageMethod {

    private final TrainRepository trainRepository;

    private final ComponentRepository componentRepository;

    public DatabaseStorage(DatabaseConfig config) {
        DatabaseConnectionFactory connectionFactory = new DatabaseConnectionFactory(config);

        this.trainRepository = new DatabaseTrainRepository(connectionFactory);
        this.componentRepository = new DatabaseComponentRepository(connectionFactory);
    }

    public TrainRepository getTrainRepository() {
        return trainRepository;
    }

    public ComponentRepository getComponentRepository() {
        return componentRepository;
    }

}

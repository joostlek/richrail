package nl.hu.richrail.persistence.database;

import nl.hu.richrail.persistence.ComponentRepository;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.database.repositories.DatabaseComponentRepository;
import nl.hu.richrail.persistence.database.repositories.DatabaseTrainRepository;
import nl.hu.richrail.persistence.loggers.ComponentRepositoryLogger;
import nl.hu.richrail.persistence.loggers.TrainRepositoryLogger;

public class DatabaseStorage implements StorageMethod {

    private final TrainRepository trainRepository;

    private final ComponentRepository componentRepository;

    public DatabaseStorage(DatabaseConfig config) {
        DatabaseConnectionFactory connectionFactory = new DatabaseConnectionFactory(config);

        this.trainRepository = new TrainRepositoryLogger(new DatabaseTrainRepository(connectionFactory));
        this.componentRepository = new ComponentRepositoryLogger(new DatabaseComponentRepository(connectionFactory));
    }

    public TrainRepository getTrainRepository() {
        return trainRepository;
    }

    public ComponentRepository getComponentRepository() {
        return componentRepository;
    }

}

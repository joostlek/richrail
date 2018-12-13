//package nl.hu.richrail.services;
//
//import nl.hu.richrail.domain.Train;
//import nl.hu.richrail.persistence.DatabaseConnection;
//import nl.hu.richrail.persistence.StorageMethod;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//public class TrainRepository implements TrainRepositoryInterface {
//
//    private final StorageMethod storage;
//
//    public TrainRepository(StorageMethod storage) {
//        this.storage = storage;
//    }
//
//    @Override
//    public Train getTrain(String name) {
//        return storage.getTrain(name);
//    }
//
//    @Override
//    public List<Train> getTrains() {
//        return storage.getAllTrains();
//    }
//
//    @Override
//    public Train saveTrain(Train train) {
//        return null;
//    }
//
//    @Override
//    public boolean deleteTrain(String name) {
//        return false;
//    }
//}

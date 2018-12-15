package nl.hu.richrail.persistence;

public interface StorageMethod {

    TrainRepository getTrainRepository();

    ComponentRepository getComponentRepository();

}

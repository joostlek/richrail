package nl.hu.richrail.services;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.type.LocomotiveBuilder;
import nl.hu.richrail.domain.rollingcomponent.type.WagonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: implement DAO
public class TrainFacade implements TrainService {
    private List<Train> trains = new ArrayList<>();
    private List<RollingComponent> rollingComponents = new ArrayList<>();

    private static Logger logger = Logger.getLogger(TrainFacade.class.getName());

    /*
     * Train services
     */
    public Train getTrain(String name) {
        for (Train train : trains) {
            if (train.getKey().equalsIgnoreCase(name)) {
                return train;
            }
        }

        return null;
    }

    public List<Train> getTrains() {
        return trains;
    }

    private boolean createTrain(Train train) {
        if (trains.contains(train)) {
            return false;
        }

        if (trains.add(train)) {
            logger.log(Level.INFO, "Created: " + train.toString());
            return true;
        }

        return false;
    }

    public boolean createTrain(String name) {
        return createTrain(new Train(name));
    }

    public boolean createTrain(String name, RollingComponent rollingComponent) {
        return createTrain(new Train(name, rollingComponent));
    }

    public boolean createTrain(String name, List<RollingComponent> rollingComponents) {
        return createTrain(new Train(name, rollingComponents));
    }

    public boolean removeTrain(String key) {
        Train train = getTrain(key);

        if (trains.remove(train)) {
            logger.log(Level.INFO, "Removed train: " + train.toString());
            return true;
        }

        return false;
    }

    /*
     * Rolling Components from Train services
     */
    public RollingComponent getRollingComponentFromTrain(String trainName, int position) {
        return getTrain(trainName).getRollingComponentFromTrain(position);
    }

    public List<RollingComponent> getRollingComponentsFromTrain(String trainName) {
        return getTrain(trainName).getRollingComponentsFromTrain();
    }

    public boolean addRollingComponentToTrain(String trainName, RollingComponent rollingComponent) {
        Train train = getTrain(trainName);

        if (train.addRollingComponentToTrain(rollingComponent)) {
            logger.log(Level.INFO, "Add rollingcomponent to train: " + train.toString());
            return true;
        }

        return false;
    }

    public boolean removeRollingComponentFromTrain(String trainName, RollingComponent rollingComponent) {
        Train train = getTrain(trainName);

        if (train.removeRollingComponentFromTrain(rollingComponent)) {
            logger.log(Level.INFO, "Remove rollingcomponent from train: " + train.toString());
            return true;
        }

        return false;
    }

    /*
     * Rolling Component services
     */
    public RollingComponent getRollingComponent(String key) {
        for (RollingComponent rollingComponent : rollingComponents) {
            if (rollingComponent.getKey().equalsIgnoreCase(key)) {
                return rollingComponent.clone();
            }
        }

        return null;
    }

    public List<RollingComponent> getRollingComponents() {
        return rollingComponents;
    }

    private boolean createRollingComponent(RollingComponent rollingComponent) {
        if (rollingComponents.contains(rollingComponent)) {
            return false;
        }

        if (rollingComponents.add(rollingComponent)) {
            logger.log(Level.INFO, "Created rollingcomponent: " + rollingComponent.toString());
            return true;
        }

        return false;
    }

    public boolean createRollingComponentLocomotive(String key, boolean hasCoals) {
        String imagePath = "";

        if (key == null || imagePath == null) {
            return false;
        }

        LocomotiveBuilder locomotiveBuilder = new LocomotiveBuilder(key, imagePath);

        locomotiveBuilder.setLocomotiveHasCoals(hasCoals);

        return createRollingComponent(locomotiveBuilder.getBuildResult());
    }

    public boolean createRollingComponentWagon(String key, int seatPlaces, int standingPlaces) {
        String imagePath = "";

        if (key == null || imagePath == null) {
            return false;
        }

        WagonBuilder wagonBuilder = new WagonBuilder(key, imagePath);

        wagonBuilder.setSeatPlaces(seatPlaces);
        wagonBuilder.setStandingPlaces(standingPlaces);

        return createRollingComponent(wagonBuilder.getBuildResult());
    }

    public boolean removeRollingComponent(String key) {
        RollingComponent rollingComponent = getRollingComponent(key);

        if (rollingComponents.remove(rollingComponent)) {
            logger.log(Level.INFO, "Romoved rollingcomponent: " + rollingComponent.toString());
            return true;
        }

        return false;
    }
}

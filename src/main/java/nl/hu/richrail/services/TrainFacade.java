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
            if (train.getId().equalsIgnoreCase(name)) {
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

    public boolean removeTrain(String id) {
        Train train = getTrain(id);

        if (trains.remove(train)) {
            logger.log(Level.INFO, "Removed train: " + train.toString());
            return true;
        }

        return false;
    }

    public int getTotalNumSeats(String id) {
        return getTrain(id).getTotalNumSeats();
    }

    /*
     * Rolling Components from Train services
     */
    public RollingComponent getRollingComponentFromTrain(String trainId, String rollingComponentId) {
        return getTrain(trainId).getRollingComponentFromTrain(rollingComponentId);
    }

    public List<RollingComponent> getRollingComponentsFromTrain(String trainId) {
        return getTrain(trainId).getRollingComponentsFromTrain();
    }

    public boolean addRollingComponentToTrain(String trainId, RollingComponent rollingComponent) {
        Train train = getTrain(trainId);

        if (train.addRollingComponentToTrain(rollingComponent)) {
            logger.log(Level.INFO, "Add rollingcomponent to train: " + train.toString());
            return true;
        }

        return false;
    }

    public boolean removeRollingComponentFromTrain(String trainId, RollingComponent rollingComponent) {
        Train train = getTrain(trainId);

        if (train.removeRollingComponentFromTrain(rollingComponent)) {
            logger.log(Level.INFO, "Remove rollingcomponent from train: " + train.toString());
            return true;
        }

        return false;
    }

    /*
     * Rolling Component services
     */
    public RollingComponent getRollingComponent(String id) {
        for (RollingComponent rollingComponent : rollingComponents) {
            if (rollingComponent.getId().equalsIgnoreCase(id)) {
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

    public boolean createRollingComponentLocomotive(String id) {
        String imagePath = "";

        if (id == null || imagePath == null) {
            return false;
        }

        LocomotiveBuilder locomotiveBuilder = new LocomotiveBuilder(id, imagePath);

        return createRollingComponent(locomotiveBuilder.getBuildResult());
    }

    public boolean createRollingComponentWagon(String id, int numSeats) {
        String imagePath = "";

        if (id == null || imagePath == null) {
            return false;
        }

        WagonBuilder wagonBuilder = new WagonBuilder(id, imagePath);

        wagonBuilder.setNumSeats(numSeats);

        return createRollingComponent(wagonBuilder.getBuildResult());
    }

    public boolean removeRollingComponent(String id) {
        RollingComponent rollingComponent = getRollingComponent(id);

        if (rollingComponents.remove(rollingComponent)) {
            logger.log(Level.INFO, "Romoved rollingcomponent: " + rollingComponent.toString());
            return true;
        }

        return false;
    }
}

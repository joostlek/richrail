package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.services.TrainService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainFacade {
    // TODO: implement DAO

    private List<Train> trains = new ArrayList<>();

    private static Logger logger = Logger.getLogger(TrainService.class.getName());

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

    public boolean createTrain(String name) {
        Train train = new Train(name);

        if (trains.contains(train)) {
            return false;
        }

        if (trains.add(train)) {
            logger.log(Level.INFO, "Created: " + train.toString());
            return true;
        }

        return false;
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

    public String getTrainsString() {
        StringBuilder stringBuilder = new StringBuilder("trains\n");

        for (Train train : trains) {
            TrainIterator trainIterator = train.createIterator();
            StringBuilder stringBuilderRollingComponents = new StringBuilder();

            stringBuilder.append("(" + train.getId() + ")");

            if (trainIterator.hasNext()) {
                stringBuilder.append("-");
            }

            while (trainIterator.hasNext()) {
                stringBuilderRollingComponents.append("{" + trainIterator.getNext().getId()  + "}");

                if (trainIterator.hasNext()) {
                    stringBuilderRollingComponents.append("-");
                }

            }

            stringBuilder.append(stringBuilderRollingComponents + "\n");
        }

        return stringBuilder.toString();
    }
}

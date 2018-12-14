package nl.hu.richrail;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.services.TrainFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDomainTest {
    public static void main(String[] args) throws IOException {

        TrainFacade trainService = TrainFacade.getInstance();

        // create rollingcomponent locomotive
        trainService.createRollingComponentLocomotive("Locomotive 1");

        // create rollingcomponent wagons
        trainService.createRollingComponentWagon("Wagon 1", 80);
        trainService.createRollingComponentWagon("Wagon 2", 90);
        trainService.createRollingComponentWagon("Wagon 3", 100);
        trainService.createRollingComponentWagon("Wagon 4", 110);

        // remove rollingcomponent
        trainService.removeRollingComponent("Wagon 4");

        // create rollingcomponents array for helloworld train
        List<RollingComponent> helloWorldTrainComponents = new ArrayList<>();
        helloWorldTrainComponents.add(trainService.getRollingComponent("Locomotive 1"));
        helloWorldTrainComponents.add(trainService.getRollingComponent("Wagon 1"));
        helloWorldTrainComponents.add(trainService.getRollingComponent("Wagon 2"));

        // create helloworld train with rollingcomponents
        trainService.createTrain("Hello world train", helloWorldTrainComponents);

        // create another helloworld train with rollingcomponent
        trainService.createTrain("Another hello world train", trainService.getRollingComponent("Locomotive 1"));

        // create another helloworld train with rollingcomponent
        trainService.createTrain("Another one hello world train");

        // get train object and add rollingcomponent
        trainService.addRollingComponentToTrain("Hello world train", trainService.getRollingComponent("Wagon 1"));

        // remove another one hello world train
        trainService.removeTrain("Another one hello world train");

        // remove wagon 1 from hello world train
        RollingComponent rollingComponentWithPosition = trainService.getRollingComponentFromTrain("Hello world train", "wagon 1");
        trainService.removeRollingComponentFromTrain("Hello world train", rollingComponentWithPosition);

        // print results
        System.out.println("\nAvailable rollingcomponents:");
        for (RollingComponent rollingComponent : trainService.getRollingComponents()) {
            System.out.println(rollingComponent.getId());
        }
        System.out.println("\nCreated Trains " + trainService.getTrains().size() + ":");
        for (Train train : trainService.getTrains()) {
            System.out.println("Naam: " + train.getId() + ", Aantal rollingcomponents: " + train.getRollingComponentsFromTrain().size());
            int i = 1;
            for (RollingComponent rollingComponent : train.getRollingComponentsFromTrain()) {
                System.out.println(i + ": " + rollingComponent.getId() + ", " + rollingComponent.getImagePath());
                i++;
            }
        }

        // other tests
        System.out.println("\nOther tests:\nHello world train locomotive 1 imagePath: " + trainService.getRollingComponentFromTrain("Hello world train", "Locomotive 1").getImagePath());
    }
}

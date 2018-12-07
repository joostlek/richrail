package nl.hu.richrail;
 
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.TrainFacade;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentFacade;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDomainTest {
    public static void main(String[] args) {
        TrainFacade trainService = new TrainFacade();
        RollingComponentFacade rollingComponentService = new RollingComponentFacade();

        // create rollingcomponent locomotive
        if (rollingComponentService.createRollingComponentLocomotive("Locomotive 1", "locomotive-one.png", true)) {
            System.out.println("Created: Locomotive 1");
        }

        // create three rollingcomponent wagons
        if (rollingComponentService.createRollingComponentWagon("Wagon 1", "wagon-one.png", 40, 110)) {
            System.out.println("Created: Wagon 1");
        }
        if (rollingComponentService.createRollingComponentWagon("Wagon 2", "wagon-two.png", 50, 100)) {
            System.out.println("Created: Wagon 2");
        }
        if (rollingComponentService.createRollingComponentWagon("Wagon 3", "wagon-three.png", 60, 90)) {
            System.out.println("Created: Wagon 3");
        }
        if (rollingComponentService.createRollingComponentWagon("Wagon 4", "wagon-four.png", 70, 80)) {
            System.out.println("Created: Wagon 4");
        }

        // remove rollingcomponent
        if (rollingComponentService.removeRollingComponent("Wagon 4")) {
            System.out.println("Removed: Wagon 4");
        }

        // create rollingcomponents array for helloworld train
        List<RollingComponent> helloWorldTrainComponents = new ArrayList<>();
        helloWorldTrainComponents.add(rollingComponentService.getRollingComponent("Locomotive 1"));
        helloWorldTrainComponents.add(rollingComponentService.getRollingComponent("Wagon 1"));
        helloWorldTrainComponents.add(rollingComponentService.getRollingComponent("Wagon 2"));

        // create helloworld train with rollingcomponents
        if (trainService.createTrain("Hello world train", helloWorldTrainComponents)) {
            System.out.println("Created: Hello world train");
        }

        // create another helloworld train with rollingcomponent
        if (trainService.createTrain("Another hello world train", rollingComponentService.getRollingComponent("Locomotive 1"))) {
            System.out.println("Created: Another hello world train");
        }

        // create another helloworld train with rollingcomponent
        if (trainService.createTrain("Another one hello world train")) {
            System.out.println("Created: Another one hello world train");
        }

        // get train object and add rollingcomponent
        Train helloWorld = trainService.getTrain("Hello world train");
        helloWorld.addTrainRollingComponent(rollingComponentService.getRollingComponent("Wagon 1"));

        // remove another one hello world train
        if (trainService.removeTrain("Another one hello world train")) {
            System.out.println("Removed: Another one hello world train");
        }

        // remove wagon 1 from hello world train
        if (trainService.getTrain("Hello world train").removeTrainRollingComponent("Wagon 1")) {
            System.out.println("Removed: Wagon 1 from Hello world train");
        }

        // print results
        System.out.println("\nAvailable rollingcomponents:");
        for (RollingComponent rollingComponent : rollingComponentService.getRollingComponents()) {
            System.out.println(rollingComponent.getKey());
        }
        System.out.println("\nCreated Trains " + trainService.getTrains().size() + ":");
        for (Train train : trainService.getTrains()) {
            System.out.println("Naam: " + train.getKey());
            System.out.println("Aantal rollingcomponents: " + train.getTrainRollingComponents().size());
            int i = 1;
            for (RollingComponent rollingComponent : train.getTrainRollingComponents()) {
                System.out.println(i + ": " + rollingComponent.getKey() + ", " + rollingComponent.getImagePath());
                i++;
            }
        }

        // other tests
        System.out.println("\nOther tests:");
        System.out.println("Hello world train locomotive 1 imagePath: " + helloWorld.getTrainRollingComponent("Locomotive 1").getImagePath());
    }
}

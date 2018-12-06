package nl.hu.richrail;
 
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.TrainFacade;

public class ApplicationDomainTest {
    public static void main(String[] args) {
        TrainFacade TrainService = new TrainFacade();

        // create train with rollingcomponents
        TrainService.createTrain("Hello world train");
        Train helloWorld = TrainService.getTrain("Hello world train");

        // print results
        for (Train train : TrainService.getTrains()) {
            System.out.println("Naam: " + train.getName());
            System.out.println("Aantal rollingcomponents: " + train.getTrainRollingComponents().size());
        }
    }
}

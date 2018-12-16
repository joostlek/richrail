package nl.hu.richrail.exceptions;

public class TrainNotFoundException extends TrainServiceException {
    public TrainNotFoundException(String trainKey) {
        super(String.format("Er bestaat geen trein met de naam '%s'.", trainKey));
    }
}

package nl.hu.richrail.exceptions;

public class TrainServiceException extends Exception {

    private final String errorMessage;

    public TrainServiceException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}

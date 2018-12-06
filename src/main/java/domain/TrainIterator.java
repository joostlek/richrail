package domain;

public interface TrainIterator {
    boolean hasNext();
    Train getNext();
    void reset();
}

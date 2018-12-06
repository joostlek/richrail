package nl.hu.richrail.domain;

public interface TrainIterator {
    boolean hasNext();
    Train getNext();
    void reset();
}

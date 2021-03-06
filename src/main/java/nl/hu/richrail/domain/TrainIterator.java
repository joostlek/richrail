package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class TrainIterator implements Iterator<RollingComponent> {

    private final Queue<RollingComponent> items;

    public TrainIterator(Train train) {
        this.items = new ArrayDeque<>(train.getAllComponents());
    }

    @Override
    public boolean hasNext() {
        return !this.items.isEmpty();
    }

    @Override
    public RollingComponent next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.items.remove();
    }

}

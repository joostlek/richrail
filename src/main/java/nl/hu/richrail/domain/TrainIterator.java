package nl.hu.richrail.domain;

import nl.hu.richrail.domain.rollingcomponent.RollingComponent;

import java.util.List;

public class TrainIterator {
    private Train train;
    private int  currentPosition = 0;
    private List<RollingComponent> rollingComponents;

    public TrainIterator(Train train) {
        this.train = train;
    }

    private void lazyLoad() {
        if (rollingComponents == null) {
            rollingComponents = train.getTrainRollingComponents();
        }
    }

    public boolean hasNext() {
        lazyLoad();
        return currentPosition < rollingComponents.size();
    }

    public RollingComponent getNext() {
        if (!hasNext()) {
            return null;
        }

        RollingComponent rollingComponent = rollingComponents.get(currentPosition);
        currentPosition++;

        return rollingComponent;
    }

    public void reset() {
        currentPosition = 0;
    }
}

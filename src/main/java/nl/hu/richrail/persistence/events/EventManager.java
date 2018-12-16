package nl.hu.richrail.persistence.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private final Map<EventType, List<EventListener>> listeners;

    public EventManager(EventType... keys) {
        this.listeners = new HashMap<>();

        for (EventType key : keys) {
            this.listeners.put(key, new ArrayList<>());
        }
    }

    public void subscribe(EventType key, EventListener listener) {
        this.listeners.get(key).add(listener);
    }

    public void notify(EventType key) {
        for (EventListener listener : this.listeners.get(key)) {
            listener.notified(key);
        }
    }

}

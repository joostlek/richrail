package nl.hu.richrail.persistence.events;

import java.util.*;

public class EventManager {

    private final Map<EventType, List<EventListener>> listeners;

    public EventManager(EventType... keys) {
        this.listeners = new EnumMap<>(EventType.class);

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

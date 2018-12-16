package nl.hu.richrail.persistence.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private final Map<String, List<EventListener>> listeners;

    public EventManager(String... keys) {
        this.listeners = new HashMap<>();

        for (String key : keys) {
            this.listeners.put(key, new ArrayList<>());
        }
    }

    public void subscribe(String key, EventListener listener) {
        this.listeners.get(key).add(listener);
    }

    public void notify(String key) {
        for (EventListener listener : this.listeners.get(key)) {
            listener.notified(key);
        }
    }

}
